package com.travel.travtronics.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.travtronics.model.Task;

@Component
public class CustomTaskServiceImpl implements CustomTaskRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Task> mahasearch(String description, Long wiw, String status, String owner, String priority,
			String urgency, LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate,
			LocalDate plannedEndDate, Long projectId, LocalDate createdDate, String createdBy) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM tms_user_task WHERE 1=1\t");

		if (description != null && !description.isBlank()) {
			sb.append("AND description = :description \t");
		}
		if (wiw != null) {
			sb.append("AND wiw = :wiw \t");
		}
		if (status != null && !status.isBlank()) {
			sb.append("AND status = :status \t");
		}
		if (owner != null && !owner.isBlank()) {
			sb.append("AND owner = :owner \t");
		}
		if (priority != null && !priority.isBlank()) {
			sb.append("AND priority = :priority \t");
		}
		if (urgency != null && !urgency.isBlank()) {
			sb.append("AND urgency = :urgency \t");
		}
		if (jobStartDate != null) {
			sb.append("AND jobStartDate = :jobStartDate \t");
		}
		if (jobEndDate != null) {
			sb.append("AND jobEndDate = :jobEndDate \t");
		}
		if (plannedStartDate != null) {
			sb.append("AND plannedStartDate = :plannedStartDate \t");
		}
		if (plannedEndDate != null) {
			sb.append("AND plannedEndDate = :plannedEndDate \t");
		}
		if (projectId != null) {
			sb.append("AND projectID =  :projectId \t");
		}
		if (createdDate != null) {
			sb.append("AND createdDate = :createdDate \t");
		}
		if (createdBy != null && !createdBy.isBlank()) {
			sb.append("AND createdBy = :createdBy \t");
		}
		Query q = entityManager.createNativeQuery(sb.toString(), Task.class);
		if (description != null && !description.isBlank()) {
			q.setParameter("description", description);
		}
		if (wiw != null ) {
			q.setParameter("wiw", wiw);
		}
		if (status != null && !status.isBlank()) {
			q.setParameter("status", status);
		}
		if (owner != null && !owner.isBlank()) {
			q.setParameter("owner", owner);
		}
		if (priority != null && !priority.isBlank()) {
			q.setParameter("priority", priority);
		}
		if (urgency != null && !urgency.isBlank()) {
			q.setParameter("urgency", urgency);
		}
		if (jobStartDate != null) {
			q.setParameter("jobStartDate", jobStartDate);
		}
		if (jobEndDate != null) {
			q.setParameter("jobEndDate", jobEndDate);
		}
		if (plannedStartDate != null) {
			q.setParameter("plannedStartDate", plannedStartDate);
		}
		if (plannedEndDate != null) {
			q.setParameter("plannedEndDate", plannedEndDate);
		}
		if (projectId != null) {
			q.setParameter("projectId", projectId);
		}
		if (createdDate != null) {
			q.setParameter("createdDate", createdDate);
		}
		if (createdBy != null && !createdBy.isBlank()) {
			q.setParameter("createdBy", createdBy);	
		}
		List<Task> taskList = q.getResultList();
		return taskList;
	}

}
