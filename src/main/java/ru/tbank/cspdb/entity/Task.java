package ru.tbank.cspdb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task", uniqueConstraints = @UniqueConstraint(name = "uq_task_project_number", columnNames = {"project_id", "number"}))
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String number;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name = "planned_payload", nullable = false)
    private Double plannedPayload;

    @Column(name = "fact_payload")
    private Double factPayload;

    @Column(name = "planned_date_of_end", nullable = false)
    private LocalDate plannedDateOfEnd;

    @Column(name = "fact_date_of_end")
    private LocalDate factDateOfEnd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_status_name", nullable = false)
    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_type_name", nullable = false)
    private TaskType taskType;

    public Long getId() { return id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPlannedPayload() { return plannedPayload; }
    public void setPlannedPayload(Double plannedPayload) { this.plannedPayload = plannedPayload; }
    public Double getFactPayload() { return factPayload; }
    public void setFactPayload(Double factPayload) { this.factPayload = factPayload; }
    public LocalDate getPlannedDateOfEnd() { return plannedDateOfEnd; }
    public void setPlannedDateOfEnd(LocalDate plannedDateOfEnd) { this.plannedDateOfEnd = plannedDateOfEnd; }
    public LocalDate getFactDateOfEnd() { return factDateOfEnd; }
    public void setFactDateOfEnd(LocalDate factDateOfEnd) { this.factDateOfEnd = factDateOfEnd; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
    public TaskStatus getTaskStatus() { return taskStatus; }
    public void setTaskStatus(TaskStatus taskStatus) { this.taskStatus = taskStatus; }
    public TaskType getTaskType() { return taskType; }
    public void setTaskType(TaskType taskType) { this.taskType = taskType; }
}
