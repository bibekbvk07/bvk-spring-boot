package com.bibek.customer_crud_demo.service;

import com.bibek.customer_crud_demo.repository.CustomerRepository;
import com.bibek.customer_crud_demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomersInCity(String city){
        return customerRepository.findAllCustomersInCity(city);
    }

    public List<Customer> getAllCustomersByZipAndState(Integer postalCode, String state){
        return customerRepository.findCustomerByPostalCodeAndState(postalCode, state);
    }
}
