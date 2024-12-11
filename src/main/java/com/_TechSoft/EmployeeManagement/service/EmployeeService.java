package com._TechSoft.EmployeeManagement.service;

import com._TechSoft.EmployeeManagement.dto.EmpolyeeRequest;
import com._TechSoft.EmployeeManagement.entity.Employee;
import com._TechSoft.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void registerEmployee(EmpolyeeRequest empolyeeRequest) {
        Employee employee = Employee.builder()
                .firstName(empolyeeRequest.getFirstName())
                .lastName(empolyeeRequest.getLastName())
                .email(empolyeeRequest.getEmail())
                .build();
        employeeRepository.save(employee);
    }

    public Employee employeeById(Long id) {
        Employee employeeById = employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException("not exist"+id));
        return employeeById;

    }

    public List<Employee> allEmployee() {
        List<Employee> all = employeeRepository.findAll();
        return all;
    }

    public Employee updateEmployees(Long id, EmpolyeeRequest empolyeeRequest) {
        Employee updateEmployee = employeeRepository.findById(id).get();

        updateEmployee.setFirstName(empolyeeRequest.getFirstName());
        updateEmployee.setLastName(empolyeeRequest.getLastName());
        updateEmployee.setEmail(empolyeeRequest.getEmail());

        employeeRepository.save(updateEmployee);
        return updateEmployee;

    }

    public void deleteEmployees(Long id) {
       employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not exist" + id));
        employeeRepository.deleteById(id);
    }
}
