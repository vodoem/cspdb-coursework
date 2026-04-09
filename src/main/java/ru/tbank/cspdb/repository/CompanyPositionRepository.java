package ru.tbank.cspdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.cspdb.entity.CompanyPosition;

public interface CompanyPositionRepository extends JpaRepository<CompanyPosition, String> {
}
