package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Override
    @EntityGraph(attributePaths = {"project", "taskStatus", "taskType"})
    List<Task> findAll();

    @EntityGraph(attributePaths = {"project", "taskStatus", "taskType"})
    List<Task> findByProjectIdOrderByNumberAsc(Long projectId);
}
