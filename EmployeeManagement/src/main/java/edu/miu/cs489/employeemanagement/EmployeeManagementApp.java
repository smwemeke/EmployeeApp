package edu.miu.cs489.employeemanagement;

import edu.miu.cs489.employeemanagement.model.Employee;
import edu.miu.cs489.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementApp {
    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Employee e1 = new Employee("John", "Doe", 50000);
            Employee e2 = new Employee("Jane", "Dona", 50000);
            Employee e3 = new Employee("Alice", "Smith", 60000);
            Employee e4 = new Employee("Bob", "Brown", 45000);
            employeeService.addEmployee(e1);
            employeeService.addEmployee(e2);
            employeeService.addEmployee(e3);
            employeeService.addEmployee(e4);

            List<Employee> list = new ArrayList<>();
            list.add(e1);
            list.add(e2);
            list.add(e3);
            list.add(e4);

            list = list.stream()
                            .sorted(Comparator.comparing(Employee::getSalary)
                                    .thenComparing(Employee::getLastName).reversed())
                    .collect(toList());
            //list.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getLastName).reversed());

            for(Employee e : list){
                System.out.println(e);
            }

        };
    }
}
