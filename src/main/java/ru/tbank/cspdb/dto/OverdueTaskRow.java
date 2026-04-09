package ru.tbank.cspdb.dto;

import java.time.LocalDate;

public record OverdueTaskRow(
        String projectName,
        String taskNumber,
        String taskName,
        String taskStatus,
        LocalDate plannedDateOfEnd,
        LocalDate factDateOfEnd
) {
}
