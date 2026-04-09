package ru.tbank.cspdb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_task_on_project", uniqueConstraints = @UniqueConstraint(name = "uq_employee_task", columnNames = {"employee_id", "task_id"}))
public class EmployeeTaskOnProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "fact_date_of_start")
    private LocalDate factDateOfStart;

    @Column(name = "planned_date_of_end")
    private LocalDate plannedDateOfEnd;

    @Column(name = "fact_date_of_end")
    private LocalDate factDateOfEnd;

    @Column(name = "planned_payload", nullable = false)
    private Double plannedPayload;

    @Column(name = "fact_payload")
    private Double factPayload;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private AssignmentStatus status;

    public Long getId() { return id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }
    public LocalDate getFactDateOfStart() { return factDateOfStart; }
    public void setFactDateOfStart(LocalDate factDateOfStart) { this.factDateOfStart = factDateOfStart; }
    public LocalDate getPlannedDateOfEnd() { return plannedDateOfEnd; }
    public void setPlannedDateOfEnd(LocalDate plannedDateOfEnd) { this.plannedDateOfEnd = plannedDateOfEnd; }
    public LocalDate getFactDateOfEnd() { return factDateOfEnd; }
    public void setFactDateOfEnd(LocalDate factDateOfEnd) { this.factDateOfEnd = factDateOfEnd; }
    public Double getPlannedPayload() { return plannedPayload; }
    public void setPlannedPayload(Double plannedPayload) { this.plannedPayload = plannedPayload; }
    public Double getFactPayload() { return factPayload; }
    public void setFactPayload(Double factPayload) { this.factPayload = factPayload; }
    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }
}
