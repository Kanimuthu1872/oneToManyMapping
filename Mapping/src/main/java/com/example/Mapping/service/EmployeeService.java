package com.example.Mapping.service;

import com.example.Mapping.model.Employee;
import com.example.Mapping.model.ProjectInterview;
import com.example.Mapping.repo.EmployeeRepository;
import com.example.Mapping.repo.ProjectInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectInterviewRepository projectInterviewRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByProjectId(Long projectId) {
        return employeeRepository.findByProject_Id(projectId);
    }

    public List<Employee> getEmployeesByProjectIdAndInterviewStatus(Long projectId, String status) {
        List<ProjectInterview> interviews = projectInterviewRepository.findByProject_IdAndStatus(projectId, status);
        return interviews.stream()
                .map(ProjectInterview::getEmployees) // Get employees from interviews
                .flatMap(Set::stream)
                .filter(employee -> employee.getProject().getId()==projectId)// Flatten the sets of employees
                .collect(Collectors.toList()); // Collect as a list

    }
}
