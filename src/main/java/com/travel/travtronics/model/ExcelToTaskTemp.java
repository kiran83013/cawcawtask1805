package com.travel.travtronics.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "task_temp")
public class ExcelToTaskTemp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taskTempId")
	private Long taskId;

	@Column(name = "actualEndDate")
	private Date actualEndDate;

	@Column(name = "actualStartDate")
	private Date actualStartDate;

	@Column(name = "assignedDate")
	private Date assignedDate;

	@Column(name = "attachments")
	private String attachments;

	@Column(name = "category")
	private Long category;

	@Column(name = "createdBy")
	private Long createdBy;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "departmentId")
	private Long departmentId;

	@Column(name = "description")
	private String description;

	
	@Column(name = "jobEndDate", columnDefinition = "datetime")
	private Date jobEndDate;

	
	@Column(name = "jobStartDate", columnDefinition = "datetime")
	private Date jobStartDate;

	@Column(name = "mileStoneId")
	private Long mileStoneId;

	@Column(name = "name")
	private String name;

	@Column(name = "notes")
	private String notes;

	@Column(name = "owner")
	private Long owner;

	@Column(name = "ownerType")
	private String ownerType;

	@Column(name = "parentTaskId")
	private Long parentTaskId;

	@Column(name = "plannedEndDate")
	private Date plannedEndDate;

	@Column(name = "plannedStartDate")
	private Date plannedStartDate;

	@Column(name = "priority")
	private String priority;

	@Column(name = "projectId")
	private Long projectId;

	@Column(name = "recordStatus")
	private Long recordStatus;

	@Column(name = "status")
	private Long status;

	@Column(name = "summary")
	private String summary;

	@Column(name = "type")
	private Long type;

	@Column(name = "updatedBy")
	private Long updateBy;

	@Column(name = "updatedDate")
	private Date updatedDate;

	@Column(name = "urgency")
	private String urgency;

	
	@Column(name = "wiw")
	private Long wiw;
	
//	@Column(name = "refId")
//	private Long refId;
//	
//	@Column(name = "refType")
//	private Long refType;
	

//	@Column(name ="statusRecord")
//	private Long statusRecord;
}
