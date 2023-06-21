package com.travel.travtronics.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.travel.travtronics.model.Task;

public interface CustomTaskRepository {

	List<Task> mahasearch(String description, Long wiw, String status, String owner, String priority, String urgency,
			LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate, LocalDate plannedEndDate,
			Long projectId, LocalDate createdDate, String createdBy);

	

//	List<Task> searchreports(String description, String wiw, String status, String owner, String priority,
//			String urgency, LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate,
//			LocalDate plannedEndDate, Long projectId, LocalDate createdDate, String createdBy);

}
