package com.bibek.customer_crud_demo.repository;

import com.bibek.customer_crud_demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c inner join Address a on c.id = a.customer.id where a.city = ?1")
    List<Customer> findAllCustomersInCity(String city);

    @Query("select c from Customer c inner join Address a on c.id = a.customer.id where a.postalCode = ?1 and a.state = ?2")
    List<Customer> findCustomerByPostalCodeAndState(Integer postalCode, String state);
}
