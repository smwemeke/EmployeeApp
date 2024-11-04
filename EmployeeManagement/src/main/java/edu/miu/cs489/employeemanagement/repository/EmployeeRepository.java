package edu.miu.cs489.employeemanagement.repository;

import edu.miu.cs489.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(Integer integer);
}
