package com.travel.travtronics.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tms_tasks_audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId")
	private Long auditId;
	
	@Column(name = "audit_action")
	private String auditAction;
	
	@Column(name = "taskId")
	private Long taskId;
	
	@Column(name = "parentTaskId")
	private Long parentTaskId;
	
	@Column(name = "milestoneId")
	private Long milestoneId;
	
	@Column(name = "projectId")
	private Long projectId;
	
	@Column(name = "departmentId")
	private Long departmentId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "type")
	private Long type;
	
	@Column(name = "status")
	private Long status;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name = "ownerType")
	private String ownerType;
	
	@Column(name = "wiw")
	private Long wiw;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "plannedStartDate")
	private LocalDate plannedStartDate;
	
	@Column(name = "plannedEndDate")
	private LocalDate plannedEndDate;
	
	@Column(name = "actualStartDate")
	private LocalDate actualStartDate;
	
	@Column(name = "actualEndDate")
	private LocalDate actualEndDate;
	
	@Column(name = "jobStartDate")
	private LocalDate jobStartDate;
	
	@Column(name = "jobEndDate")
	private LocalDate jobEndDate;
	
	@Column(name = "attachments")
	private String attachments;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "urgency")
	private String urgency;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "createdDate")
	private LocalDate createdDate;
	
	@Column(name = "assignedDate")
	private LocalDate assignedDate;
	
	@Column(name = "updatedBy")
	private String updateBy;
	
	@Column(name = "updatedDate")
	private LocalDate updatedDate;
	
	@Column(name = "recordStatus")
	private String recordStatus;
	
	@Column(name = "auditCreatedDate")
	private LocalDate auditCreatedDate;
	
	@Column(name = "auditUpdatedDate")
	private LocalDate auditUpdatedDate;
}
