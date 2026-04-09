package ru.tbank.cspdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_position")
public class CompanyPosition {
    @Id
    @Column(length = 100)
    private String name;

    @Column(name = "task_complexity", nullable = false)
    private Long taskComplexity;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getTaskComplexity() { return taskComplexity; }
    public void setTaskComplexity(Long taskComplexity) { this.taskComplexity = taskComplexity; }
}
