package ru.tbank.cspdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_type")
public class ProjectType {
    @Id
    @Column(length = 100)
    private String name;

    @Column(nullable = false)
    private Long priority;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getPriority() { return priority; }
    public void setPriority(Long priority) { this.priority = priority; }
}
