package com.bibek.customer_crud_demo.restcontroller;

import com.bibek.customer_crud_demo.entity.Customer;
import com.bibek.customer_crud_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bvk/customers")
public class CustomerController {
    private final CustomerService customerService;

    // Customer injection
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // expose "/city" endpoints to list all customers
    @GetMapping("/city/{city}")
    public List<Customer> getAllCustomers(@PathVariable String city){
        return customerService.getAllCustomersInCity(city);
    }

    // expose "/zip-state/{postalCode}/{state}" endpoints to list al customers with the postalCode and state that matched @Param value
    @GetMapping("/zip-state/{postalCode}/{state}")
    public List<Customer> getCustomersByPostalAndState(@PathVariable Integer postalCode, @PathVariable String state){
        return customerService.getAllCustomersByZipAndState(postalCode, state);
    }
}
