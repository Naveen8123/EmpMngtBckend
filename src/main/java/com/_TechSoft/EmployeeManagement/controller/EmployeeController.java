package com._TechSoft.EmployeeManagement.controller;

import com._TechSoft.EmployeeManagement.dto.EmpolyeeRequest;
import com._TechSoft.EmployeeManagement.entity.Employee;
import com._TechSoft.EmployeeManagement.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerEmplyee(@RequestBody EmpolyeeRequest empolyeeRequest){
        employeeService.registerEmployee(empolyeeRequest);
        return ResponseEntity.ok("employee saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> employeeById(@PathVariable Long id){
        Employee employee = employeeService.employeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> allEmployees(){
        List<Employee> employee = employeeService.allEmployee();
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable Long id,@RequestBody EmpolyeeRequest employeeRequest){
        Employee employee = employeeService.updateEmployees(id,employeeRequest);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateEmployees(@PathVariable Long id){
        employeeService.deleteEmployees(id);
        return ResponseEntity.ok("employee deleted succesfully");
    }
}
