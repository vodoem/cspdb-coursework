package ru.tbank.cspdb.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tbank.cspdb.dto.ProjectAssignmentForm;
import ru.tbank.cspdb.entity.EmployeeProjectRole;
import ru.tbank.cspdb.exception.DuplicateAssignmentException;
import ru.tbank.cspdb.repository.*;

import java.util.List;

@Service
public class ProjectAssignmentService {
    private final EmployeeProjectRoleRepository employeeProjectRoleRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final ProjectRoleRepository projectRoleRepository;

    public ProjectAssignmentService(EmployeeProjectRoleRepository employeeProjectRoleRepository,
                                    EmployeeRepository employeeRepository,
                                    ProjectRepository projectRepository,
                                    ProjectRoleRepository projectRoleRepository) {
        this.employeeProjectRoleRepository = employeeProjectRoleRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.projectRoleRepository = projectRoleRepository;
    }

    public List<EmployeeProjectRole> findByProjectId(Long projectId) {
        return employeeProjectRoleRepository.findByProjectIdOrderByEmployeeSurnameAsc(projectId);
    }

    public List<EmployeeProjectRole> findByEmployeeId(Long employeeId) {
        return employeeProjectRoleRepository.findByEmployeeIdOrderByProjectNameAsc(employeeId);
    }

    @Transactional
    public Long assign(ProjectAssignmentForm form) {
        EmployeeProjectRole assignment = new EmployeeProjectRole();
        assignment.setEmployee(employeeRepository.findById(form.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Сотрудник не найден")));
        assignment.setProject(projectRepository.findById(form.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден")));
        assignment.setProjectRole(projectRoleRepository.findById(form.getProjectRoleName())
                .orElseThrow(() -> new IllegalArgumentException("Роль проекта не найдена")));
        try {
            employeeProjectRoleRepository.save(assignment);
            return assignment.getProject().getId();
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateAssignmentException("Такое назначение сотрудника на проект уже существует.");
        }
    }
}
