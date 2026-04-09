package ru.tbank.cspdb.dto;

import jakarta.validation.constraints.NotNull;

public class ProjectAssignmentForm {
    @NotNull(message = "Выберите сотрудника")
    private Long employeeId;

    @NotNull(message = "Выберите проект")
    private Long projectId;

    @NotNull(message = "Выберите роль")
    private String projectRoleName;

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public String getProjectRoleName() { return projectRoleName; }
    public void setProjectRoleName(String projectRoleName) { this.projectRoleName = projectRoleName; }
}
