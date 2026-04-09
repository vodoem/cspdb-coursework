package ru.tbank.cspdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.tbank.cspdb.service.EmployeeService;
import ru.tbank.cspdb.service.ProjectAssignmentService;
import ru.tbank.cspdb.service.TaskAssignmentService;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ProjectAssignmentService projectAssignmentService;
    private final TaskAssignmentService taskAssignmentService;

    public EmployeeController(EmployeeService employeeService,
                              ProjectAssignmentService projectAssignmentService,
                              TaskAssignmentService taskAssignmentService) {
        this.employeeService = employeeService;
        this.projectAssignmentService = projectAssignmentService;
        this.taskAssignmentService = taskAssignmentService;
    }

    @GetMapping("/employees")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees/list";
    }

    @GetMapping("/employees/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("projectAssignments", projectAssignmentService.findByEmployeeId(id));
        model.addAttribute("taskAssignments", taskAssignmentService.findByEmployeeId(id));
        return "employees/details";
    }
}
