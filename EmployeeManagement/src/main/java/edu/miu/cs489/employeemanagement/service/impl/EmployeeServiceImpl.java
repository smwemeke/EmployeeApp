package edu.miu.cs489.employeemanagement.service.impl;

import edu.miu.cs489.employeemanagement.model.Employee;
import edu.miu.cs489.employeemanagement.repository.EmployeeRepository;
import edu.miu.cs489.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> addEmployee(Employee employee) {
        Employee newemployee = employeeRepository.save(employee);
        return Optional.of(newemployee);
    }
    @Override
    public void updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());
        if(existingEmployee.isPresent()){
            employeeRepository.save(employee);
        }
        else{
            System.out.println("Employee with ID" + employee.getId() + " not found");
        }
    }
    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
