package com.example.Mapping.controller;

import com.example.Mapping.model.Employee;
import com.example.Mapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees/project/{projectId}")
    public ResponseEntity<List<Employee>> getEmployeesByProjectId(@PathVariable Long projectId) {
        List<Employee> employees = employeeService.getEmployeesByProjectId(projectId);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/project/{projectId}/interview-status/{status}")
    public ResponseEntity<List<Employee>> getEmployeesByProjectIdAndInterviewStatus(
            @PathVariable Long projectId,
            @PathVariable String status) {
        List<Employee> employees = employeeService.getEmployeesByProjectIdAndInterviewStatus(projectId, status);
        return ResponseEntity.ok(employees);
    }
}
