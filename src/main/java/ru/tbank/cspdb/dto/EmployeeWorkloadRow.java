package ru.tbank.cspdb.dto;

import ru.tbank.cspdb.entity.AssignmentStatus;

public record EmployeeWorkloadRow(
        String employee,
        String project,
        String taskNumber,
        String taskName,
        AssignmentStatus assignmentStatus,
        Double plannedPayload,
        Double factPayload
) {
}
