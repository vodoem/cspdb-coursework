package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.EmployeeProjectRole;

import java.util.List;

public interface EmployeeProjectRoleRepository extends JpaRepository<EmployeeProjectRole, Long> {
    @EntityGraph(attributePaths = {"employee", "project", "projectRole"})
    List<EmployeeProjectRole> findByProjectIdOrderByEmployeeSurnameAsc(Long projectId);

    @EntityGraph(attributePaths = {"employee", "project", "projectRole"})
    List<EmployeeProjectRole> findByEmployeeIdOrderByProjectNameAsc(Long employeeId);
}
