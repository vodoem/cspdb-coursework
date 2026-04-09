package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.ProjectRole;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, String> {
}
