package com.bibek.employeemanagementsystem.repository;

import com.bibek.employeemanagementsystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
