package com.example.Mapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "interview_id", nullable = false)
    private ProjectInterview projectInterview;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
