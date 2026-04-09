package ru.tbank.cspdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_type")
public class TaskType {
    @Id
    @Column(length = 100)
    private String name;

    @Column(nullable = false)
    private Long complexity;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getComplexity() { return complexity; }
    public void setComplexity(Long complexity) { this.complexity = complexity; }
}
