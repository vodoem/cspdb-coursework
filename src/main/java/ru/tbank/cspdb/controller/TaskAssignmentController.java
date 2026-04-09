package ru.tbank.cspdb.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tbank.cspdb.dto.TaskAssignmentForm;
import ru.tbank.cspdb.entity.AssignmentStatus;
import ru.tbank.cspdb.exception.DuplicateAssignmentException;
import ru.tbank.cspdb.repository.EmployeeRepository;
import ru.tbank.cspdb.repository.TaskRepository;
import ru.tbank.cspdb.service.TaskAssignmentService;

@Controller
public class TaskAssignmentController {
    private final TaskAssignmentService taskAssignmentService;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService,
                                    EmployeeRepository employeeRepository,
                                    TaskRepository taskRepository) {
        this.taskAssignmentService = taskAssignmentService;
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task-assignments/new")
    public String createForm(Model model) {
        model.addAttribute("taskAssignmentForm", new TaskAssignmentForm());
        fillDictionaries(model);
        return "assignments/task-assignment-form";
    }

    @PostMapping("/task-assignments/new")
    public String create(@Valid @ModelAttribute TaskAssignmentForm taskAssignmentForm,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            fillDictionaries(model);
            return "assignments/task-assignment-form";
        }

        try {
            Long taskId = taskAssignmentService.assign(taskAssignmentForm);
            return "redirect:/tasks/" + taskId;
        } catch (DuplicateAssignmentException ex) {
            model.addAttribute("dbError", ex.getMessage());
            fillDictionaries(model);
            return "assignments/task-assignment-form";
        }
    }

    private void fillDictionaries(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("statuses", AssignmentStatus.values());
    }
}
