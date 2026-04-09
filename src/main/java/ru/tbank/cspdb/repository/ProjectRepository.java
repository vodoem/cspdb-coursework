package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Override
    @EntityGraph(attributePaths = {"projectType", "responsibleEmployee", "responsibleEmployee.companyPosition"})
    List<Project> findAll();
}
