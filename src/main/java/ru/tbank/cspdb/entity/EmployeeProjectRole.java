package ru.tbank.cspdb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_project_role", uniqueConstraints = @UniqueConstraint(name = "uq_employee_project_role", columnNames = {"employee_id", "project_id", "project_role_name"}))
public class EmployeeProjectRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_role_name", nullable = false)
    private ProjectRole projectRole;

    public Long getId() { return id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
    public ProjectRole getProjectRole() { return projectRole; }
    public void setProjectRole(ProjectRole projectRole) { this.projectRole = projectRole; }
}
