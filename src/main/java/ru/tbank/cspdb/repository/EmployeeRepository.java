package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
