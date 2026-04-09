package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, String> {
}
