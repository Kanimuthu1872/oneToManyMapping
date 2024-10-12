package com.example.Mapping.repo;

import com.example.Mapping.model.ProjectInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectInterviewRepository extends JpaRepository<ProjectInterview, Long> {
    List<ProjectInterview> findByProject_IdAndStatus(Long projectId, String status);
}
