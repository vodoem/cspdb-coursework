package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, String> {
}
