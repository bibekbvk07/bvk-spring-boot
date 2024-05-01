package com.bibek.employeemanagementsystem.repository;

import com.bibek.employeemanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
