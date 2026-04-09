package ru.tbank.cspdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tbank.cspdb.service.TaskAssignmentService;
import ru.tbank.cspdb.service.TaskService;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final TaskAssignmentService taskAssignmentService;

    public TaskController(TaskService taskService, TaskAssignmentService taskAssignmentService) {
        this.taskService = taskService;
        this.taskAssignmentService = taskAssignmentService;
    }

    @GetMapping("/tasks")
    public String list(@RequestParam(required = false) Long projectId, Model model) {
        model.addAttribute("tasks", projectId == null ? taskService.findAll() : taskService.findByProjectId(projectId));
        model.addAttribute("selectedProjectId", projectId);
        return "tasks/list";
    }

    @GetMapping("/tasks/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("assignments", taskAssignmentService.findByTaskId(id));
        return "tasks/details";
    }
}
