package com.bibek.cruddemo;

import com.bibek.cruddemo.dao.EmployeeDAO;
import com.bibek.cruddemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO){
        return runner ->{
            createEmployee(employeeDAO);
            findEmployee(employeeDAO);
            findAllEmployees(employeeDAO);
            searchEmployeeByFirstName(employeeDAO);
            updateEmployee(employeeDAO);
            removeEmployeeById(employeeDAO);
//            deleteAllEmployee(employeeDAO);
        };
    }

    private void deleteAllEmployee(EmployeeDAO employeeDAO) {
        System.out.println(employeeDAO.deleteAll());
    }

    private void removeEmployeeById(EmployeeDAO employeeDAO) {
        employeeDAO.delete(5);
    }

    private void updateEmployee(EmployeeDAO employeeDAO) {
        // Storing the list of atl the employees from database
        List<Employee> employeeList = employeeDAO.findAll();
        System.out.println("Before update operation: ");
        for (Employee emp: employeeList) {
            System.out.println(emp.toString());
        }
        // Performing update operations on data whose first name is "Sanjog"
        for (Employee emp: employeeList) {
            if (emp.getFirstName().equalsIgnoreCase("sanjog")){
                emp.setFirstName("Bipin");
                employeeDAO.update(emp);
            } else if (emp.getLastName().equalsIgnoreCase("shrestha")) {
                emp.setLastName("Shakya");
                employeeDAO.update(emp);
            }
        }
        System.out.println("After update operation: ");
        for (Employee emp: employeeList) {
            System.out.println(emp.toString());
        }
    }

    private void searchEmployeeByFirstName(EmployeeDAO employeeDAO) {
        List<Employee> tempEmp = employeeDAO.findByFirstName("Andila");
        System.out.println("Search Results...");
        for (Employee emp: tempEmp) {
            System.out.println(emp.getEmpId() + " "+ emp.getFirstName()+" "+ emp.getLastName());
        }
    }

    private void findAllEmployees(EmployeeDAO employeeDAO) {
        // Storing the list of employee object in employeeList
        List<Employee> employeeList = employeeDAO.findAll();

        System.out.println("Employee List...");
        // Printing out the employees
        for (Employee emp: employeeList) {
            System.out.println(emp);
        }
    }

    private void findEmployee(EmployeeDAO employeeDAO) {
        // Creating Employee objects
        Employee emp6 = new Employee("Andila", "Adhikari", "andila.adhikari@code.com");
        // Saving the objects
        employeeDAO.save(emp6);

        // Finding the employee by id, returns employee object
        Employee theEmp = employeeDAO.findById(emp6.getEmpId());
        System.out.println("Employee Found: "+ theEmp);
    }

    private void createEmployee(EmployeeDAO employeeDAO) {
        // Create Employee objects
        Employee emp1 = new Employee("Prashit", "Shrestha", "prashit.shrestha@code.com");
        Employee emp2 = new Employee("Shrawan", "Thakuri", "shrawan.thakuri@code.com");
        Employee emp3 = new Employee("Ravi", "Dhungana", "ravi.dhungana@code.com");
        Employee emp4 = new Employee("Kabhindra", "Khand", "kabhndra.khand@code.com");
        Employee emp5 = new Employee("Sanjog", "Bhattarai", "sanjog.bhattarai@code.com");
        Employee emp7 = new Employee("Andila", "Shrestha", "andila.shrestha@code.com");

        // Save the object in the database
        employeeDAO.save(emp1);
        employeeDAO.save(emp2);
        employeeDAO.save(emp3);
        employeeDAO.save(emp4);
        employeeDAO.save(emp5);
        employeeDAO.save(emp7);
    }
}
