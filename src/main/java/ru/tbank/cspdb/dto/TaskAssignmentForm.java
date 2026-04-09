package ru.tbank.cspdb.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import ru.tbank.cspdb.entity.AssignmentStatus;

public class TaskAssignmentForm {
    @NotNull(message = "Выберите сотрудника")
    private Long employeeId;

    @NotNull(message = "Выберите задачу")
    private Long taskId;

    @NotNull(message = "Укажите статус")
    private AssignmentStatus status;

    @NotNull(message = "Укажите плановую трудоемкость")
    @DecimalMin(value = "0.0", inclusive = true, message = "Плановая трудоемкость должна быть >= 0")
    private Double plannedPayload;

    @DecimalMin(value = "0.0", inclusive = true, message = "Фактическая трудоемкость должна быть >= 0")
    private Double factPayload;

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }
    public Double getPlannedPayload() { return plannedPayload; }
    public void setPlannedPayload(Double plannedPayload) { this.plannedPayload = plannedPayload; }
    public Double getFactPayload() { return factPayload; }
    public void setFactPayload(Double factPayload) { this.factPayload = factPayload; }
}
