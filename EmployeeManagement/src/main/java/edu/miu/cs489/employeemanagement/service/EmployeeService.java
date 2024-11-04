package edu.miu.cs489.employeemanagement.service;

import edu.miu.cs489.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Optional<Employee> addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);

}
