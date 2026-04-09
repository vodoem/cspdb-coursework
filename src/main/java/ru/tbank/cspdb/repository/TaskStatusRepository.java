package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.TaskStatus;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, String> {
}
