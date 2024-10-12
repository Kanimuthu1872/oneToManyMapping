package com.example.Mapping.repo;

import com.example.Mapping.model.Employee;
import com.example.Mapping.model.ProjectInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByProject_Id(Long projectId);// New method to find employees by project ID


}
