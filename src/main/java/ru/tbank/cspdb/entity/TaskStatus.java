package ru.tbank.cspdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_status")
public class TaskStatus {
    @Id
    @Column(length = 100)
    private String name;

    @Column(name = "percentage_of_done", nullable = false)
    private Long percentageOfDone;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getPercentageOfDone() { return percentageOfDone; }
    public void setPercentageOfDone(Long percentageOfDone) { this.percentageOfDone = percentageOfDone; }
}
