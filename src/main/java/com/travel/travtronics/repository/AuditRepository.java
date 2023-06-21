package com.travel.travtronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long>{

}
