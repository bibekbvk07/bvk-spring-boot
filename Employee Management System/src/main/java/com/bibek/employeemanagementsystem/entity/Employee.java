package com.bibek.employeemanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    // Define fields for employee entity
    @Id
    @SequenceGenerator(
            name = "employeeSequence",
            sequenceName = "employeeSequence",
            initialValue = 1000,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequence")
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "hire_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hire_date;

    @ManyToOne
    @JoinColumn(name = "dept_id",
            referencedColumnName = "dept_id",
            foreignKey = @ForeignKey(name = "Employee_Dept_ID_FK"))
    private Department department;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Address> addresses;

    @OneToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(name = "Employee_User_ID_FK"))
    private User user;

    // Define a no-args constructor
    public Employee() {
    }

    // Define all-args constructor

    public Employee(String firstName, String middleName, String lastName, Date dob, String email, Date hire_date, Department department, User user) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.hire_date = hire_date;
        this.department = department;
        this.user = user;
    }


    // Define getter and setter

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // Define toString() methods

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", hire_date=" + hire_date +
                '}';
    }
}
