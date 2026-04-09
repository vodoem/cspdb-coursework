package ru.tbank.cspdb.service;

import org.springframework.stereotype.Service;
import ru.tbank.cspdb.dto.EmployeeWorkloadRow;
import ru.tbank.cspdb.dto.OverdueTaskRow;
import ru.tbank.cspdb.entity.Project;
import ru.tbank.cspdb.repository.EmployeeTaskOnProjectRepository;
import ru.tbank.cspdb.repository.ProjectRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {
    private final ProjectRepository projectRepository;
    private final EmployeeTaskOnProjectRepository employeeTaskOnProjectRepository;

    public ReportService(ProjectRepository projectRepository,
                         EmployeeTaskOnProjectRepository employeeTaskOnProjectRepository) {
        this.projectRepository = projectRepository;
        this.employeeTaskOnProjectRepository = employeeTaskOnProjectRepository;
    }

    public List<Project> projectPayloadReport() {
        return projectRepository.findAll();
    }

    public List<EmployeeWorkloadRow> employeeWorkloadReport() {
        return employeeTaskOnProjectRepository.findEmployeeWorkloadReport();
    }

    public List<OverdueTaskRow> overdueTasksReport() {
        return employeeTaskOnProjectRepository.findOverdueTasks(LocalDate.now());
    }
}
