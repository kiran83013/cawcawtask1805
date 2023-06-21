package com.travel.travtronics.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tms_user_task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taskId")
	private Long taskId;

	@Column(name = "parentTaskId")
	private Long parentTaskId;

	@Column(name = "milestoneId")
	private Long mileStoneId;

	@Column(name = "projectId")
	private Long projectId;

	@Column(name = "departmentId")
	private Long departmentId;

	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private String category;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	private String status;

	@Column(name = "owner")
	private String owner;

	@Column(name = "ownerType")
	private String ownerType;

	@Column(name = "wiw")
	private Long wiw;

	@Column(name = "summary", columnDefinition = "LONGTEXT")
	private String summary;

	@Column(name = "description", columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "plannedStartDate")
	private LocalDate plannedStartDate;

	@Column(name = "plannedEndDate")
	private LocalDate plannedEndDate;

	@Column(name = "actualStartDate")
	private LocalDate actualStartDate;

	@Column(name = "actualEndDate")
	private LocalDate actualEndDate;

	@Column(name = "jobStartDate", columnDefinition = "datetime")
	private LocalDate jobStartDate;

	@Column(name = "jobEndDate", columnDefinition = "datetime")
	private LocalDate jobEndDate;

	@Column(name = "attachments")
	private String attachments;

	@Column(name = "notes")
	private String notes;

	@Column(name = "priority")
	private String priority;

	@Column(name = "urgency")
	private String urgency;

	@Column(name = "createdBy",updatable = false)
	private String createdBy;
	
	@CreationTimestamp
	@Column(name = "createdDate",updatable = false)
	private LocalDate createdDate;

	@Column(name = "assignedDate")
	private LocalDate assignedDate;

	@Column(name = "updatedBy")
	private String updateBy;
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
	private LocalDate updatedDate;

	@Column(name = "recordStatus")
	private String recordStatus;
}
