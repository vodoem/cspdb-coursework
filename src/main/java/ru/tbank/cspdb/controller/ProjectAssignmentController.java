package ru.tbank.cspdb.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tbank.cspdb.dto.ProjectAssignmentForm;
import ru.tbank.cspdb.exception.DuplicateAssignmentException;
import ru.tbank.cspdb.repository.EmployeeRepository;
import ru.tbank.cspdb.repository.ProjectRepository;
import ru.tbank.cspdb.repository.ProjectRoleRepository;
import ru.tbank.cspdb.service.ProjectAssignmentService;

@Controller
public class ProjectAssignmentController {
    private final ProjectAssignmentService projectAssignmentService;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final ProjectRoleRepository projectRoleRepository;

    public ProjectAssignmentController(ProjectAssignmentService projectAssignmentService,
                                       EmployeeRepository employeeRepository,
                                       ProjectRepository projectRepository,
                                       ProjectRoleRepository projectRoleRepository) {
        this.projectAssignmentService = projectAssignmentService;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.projectRoleRepository = projectRoleRepository;
    }

    @GetMapping("/project-assignments/new")
    public String createForm(Model model) {
        model.addAttribute("projectAssignmentForm", new ProjectAssignmentForm());
        fillDictionaries(model);
        return "assignments/project-assignment-form";
    }

    @PostMapping("/project-assignments/new")
    public String create(@Valid @ModelAttribute ProjectAssignmentForm projectAssignmentForm,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            fillDictionaries(model);
            return "assignments/project-assignment-form";
        }

        try {
            Long projectId = projectAssignmentService.assign(projectAssignmentForm);
            return "redirect:/projects/" + projectId;
        } catch (DuplicateAssignmentException ex) {
            model.addAttribute("dbError", ex.getMessage());
            fillDictionaries(model);
            return "assignments/project-assignment-form";
        }
    }

    private void fillDictionaries(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("projectRoles", projectRoleRepository.findAll());
    }
}
