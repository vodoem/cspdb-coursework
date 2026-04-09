package ru.tbank.cspdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.tbank.cspdb.service.ProjectAssignmentService;
import ru.tbank.cspdb.service.ProjectService;
import ru.tbank.cspdb.service.TaskService;

@Controller
public class ProjectController {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final ProjectAssignmentService projectAssignmentService;

    public ProjectController(ProjectService projectService,
                             TaskService taskService,
                             ProjectAssignmentService projectAssignmentService) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.projectAssignmentService = projectAssignmentService;
    }

    @GetMapping("/projects")
    public String list(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "projects/list";
    }

    @GetMapping("/projects/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.findById(id));
        model.addAttribute("tasks", taskService.findByProjectId(id));
        model.addAttribute("assignments", projectAssignmentService.findByProjectId(id));
        return "projects/details";
    }
}
