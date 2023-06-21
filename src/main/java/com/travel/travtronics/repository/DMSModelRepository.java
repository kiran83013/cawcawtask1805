package com.travel.travtronics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.model.DMSModel;


public interface DMSModelRepository extends JpaRepository<DMSModel, Long> {
	
	List<DMSModel> findAllByEntityTypeAndEntityId(String entityType, String entityId);
	
	Optional<DMSModel> findTopByEntityTypeAndEntityId(String entityType, String entityId);
	
	Optional<DMSModel> findTopByEntityTypeAndEntityIdOrderByDocId(String entityType, String entityId);

}
