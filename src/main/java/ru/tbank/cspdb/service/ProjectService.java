package ru.tbank.cspdb.service;

import org.springframework.stereotype.Service;
import ru.tbank.cspdb.entity.Project;
import ru.tbank.cspdb.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Проект не найден: " + id));
    }
}
