package ru.tbank.cspdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_role")
public class ProjectRole {
    @Id
    @Column(length = 100)
    private String name;

    @Column(name = "percentage_of_up")
    private Long percentageOfUp;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getPercentageOfUp() { return percentageOfUp; }
    public void setPercentageOfUp(Long percentageOfUp) { this.percentageOfUp = percentageOfUp; }
}
