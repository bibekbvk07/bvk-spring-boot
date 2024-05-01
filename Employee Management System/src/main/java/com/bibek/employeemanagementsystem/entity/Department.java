package com.bibek.employeemanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    // Define fields for Department entity
    @Id
    @Column(name = "dept_id")
    @SequenceGenerator(
            name = "departmentSequence",
            sequenceName = "departmentSequence",
            initialValue = 100,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSequence")
    private Integer deptId;
    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z ()&]+$", message = "accepts only letters.")
    @Column(name = "department_name", nullable = false, unique = true)
    private String name;
    @NotNull(message = "is required")
    @Column(name = "email", nullable = false)
    private String email;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;

    // Define a no-args constructor
    public Department() {
    }

    // Define all-args constructor
    public Department(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Define getter and setter

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    // Define toString() methods

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
