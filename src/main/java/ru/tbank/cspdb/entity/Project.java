package ru.tbank.cspdb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name = "date_of_start", nullable = false)
    private LocalDate dateOfStart;

    @Column(name = "planned_date_of_end", nullable = false)
    private LocalDate plannedDateOfEnd;

    @Column(name = "fact_date_of_end")
    private LocalDate factDateOfEnd;

    @Column(name = "planned_payload", nullable = false)
    private Double plannedPayload;

    @Column(name = "fact_payload")
    private Double factPayload;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private ProjectStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_type_name", nullable = false)
    private ProjectType projectType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "responsible_employee_id", nullable = false)
    private Employee responsibleEmployee;

    public Long getId() { return id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDateOfStart() { return dateOfStart; }
    public void setDateOfStart(LocalDate dateOfStart) { this.dateOfStart = dateOfStart; }
    public LocalDate getPlannedDateOfEnd() { return plannedDateOfEnd; }
    public void setPlannedDateOfEnd(LocalDate plannedDateOfEnd) { this.plannedDateOfEnd = plannedDateOfEnd; }
    public LocalDate getFactDateOfEnd() { return factDateOfEnd; }
    public void setFactDateOfEnd(LocalDate factDateOfEnd) { this.factDateOfEnd = factDateOfEnd; }
    public Double getPlannedPayload() { return plannedPayload; }
    public void setPlannedPayload(Double plannedPayload) { this.plannedPayload = plannedPayload; }
    public Double getFactPayload() { return factPayload; }
    public void setFactPayload(Double factPayload) { this.factPayload = factPayload; }
    public ProjectStatus getStatus() { return status; }
    public void setStatus(ProjectStatus status) { this.status = status; }
    public ProjectType getProjectType() { return projectType; }
    public void setProjectType(ProjectType projectType) { this.projectType = projectType; }
    public Employee getResponsibleEmployee() { return responsibleEmployee; }
    public void setResponsibleEmployee(Employee responsibleEmployee) { this.responsibleEmployee = responsibleEmployee; }
}
