package ru.tbank.cspdb.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tbank.cspdb.dto.TaskAssignmentForm;
import ru.tbank.cspdb.entity.EmployeeTaskOnProject;
import ru.tbank.cspdb.exception.DuplicateAssignmentException;
import ru.tbank.cspdb.repository.EmployeeRepository;
import ru.tbank.cspdb.repository.EmployeeTaskOnProjectRepository;
import ru.tbank.cspdb.repository.TaskRepository;

import java.util.List;

@Service
public class TaskAssignmentService {
    private final EmployeeTaskOnProjectRepository employeeTaskOnProjectRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    public TaskAssignmentService(EmployeeTaskOnProjectRepository employeeTaskOnProjectRepository,
                                 EmployeeRepository employeeRepository,
                                 TaskRepository taskRepository) {
        this.employeeTaskOnProjectRepository = employeeTaskOnProjectRepository;
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    public List<EmployeeTaskOnProject> findByTaskId(Long taskId) {
        return employeeTaskOnProjectRepository.findByTaskIdOrderByEmployeeSurnameAsc(taskId);
    }

    public List<EmployeeTaskOnProject> findByEmployeeId(Long employeeId) {
        return employeeTaskOnProjectRepository.findByEmployeeIdOrderByTaskProjectNameAsc(employeeId);
    }

    @Transactional
    public Long assign(TaskAssignmentForm form) {
        EmployeeTaskOnProject assignment = new EmployeeTaskOnProject();
        assignment.setEmployee(employeeRepository.findById(form.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник не найден")));
        assignment.setTask(taskRepository.findById(form.getTaskId())
                .orElseThrow(() -> new IllegalArgumentException("Задача не найдена")));
        assignment.setStatus(form.getStatus());
        assignment.setPlannedPayload(form.getPlannedPayload());
        assignment.setFactPayload(form.getFactPayload());
        try {
            employeeTaskOnProjectRepository.save(assignment);
            return assignment.getTask().getId();
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateAssignmentException("Сотрудник уже назначен на эту задачу.");
        }
    }
}
