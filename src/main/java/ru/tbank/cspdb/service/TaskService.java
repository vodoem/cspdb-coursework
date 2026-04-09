package ru.tbank.cspdb.service;

import org.springframework.stereotype.Service;
import ru.tbank.cspdb.entity.Task;
import ru.tbank.cspdb.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByProjectId(Long projectId) {
        return taskRepository.findByProjectIdOrderByNumberAsc(projectId);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Задача не найдена: " + id));
    }
}
