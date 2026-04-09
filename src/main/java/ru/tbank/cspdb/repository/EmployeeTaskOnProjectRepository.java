package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tbank.cspdb.dto.EmployeeWorkloadRow;
import ru.tbank.cspdb.dto.OverdueTaskRow;
import ru.tbank.cspdb.entity.EmployeeTaskOnProject;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeTaskOnProjectRepository extends JpaRepository<EmployeeTaskOnProject, Long> {
    @EntityGraph(attributePaths = {"employee", "task", "task.project"})
    List<EmployeeTaskOnProject> findByTaskIdOrderByEmployeeSurnameAsc(Long taskId);

    @EntityGraph(attributePaths = {"employee", "task", "task.project"})
    List<EmployeeTaskOnProject> findByEmployeeIdOrderByTaskProjectNameAsc(Long employeeId);

    @Query("""
            select new ru.tbank.cspdb.dto.EmployeeWorkloadRow(
                concat(e.surname, ' ', e.name), p.name, t.number, t.name, et.status, et.plannedPayload, et.factPayload
            )
            from EmployeeTaskOnProject et
            join et.employee e
            join et.task t
            join t.project p
            order by e.surname, p.name, t.number
            """)
    List<EmployeeWorkloadRow> findEmployeeWorkloadReport();

    @Query("""
            select new ru.tbank.cspdb.dto.OverdueTaskRow(
                p.name, t.number, t.name, t.taskStatus.name, t.plannedDateOfEnd, t.factDateOfEnd
            )
            from Task t
            join t.project p
            where t.plannedDateOfEnd < :today
              and t.taskStatus.name <> 'DONE'
            order by p.name, t.plannedDateOfEnd
            """)
    List<OverdueTaskRow> findOverdueTasks(LocalDate today);
}
