package ru.tbank.cspdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tbank.cspdb.service.ReportService;

@Controller
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports")
    public String reportsHome() {
        return "reports/index";
    }

    @GetMapping("/reports/projects-payload")
    public String projectPayload(Model model) {
        model.addAttribute("rows", reportService.projectPayloadReport());
        return "reports/projects-payload";
    }

    @GetMapping("/reports/employee-workload")
    public String employeeWorkload(Model model) {
        model.addAttribute("rows", reportService.employeeWorkloadReport());
        return "reports/employee-workload";
    }

    @GetMapping("/reports/overdue-tasks")
    public String overdueTasks(Model model) {
        model.addAttribute("rows", reportService.overdueTasksReport());
        return "reports/overdue-tasks";
    }
}
