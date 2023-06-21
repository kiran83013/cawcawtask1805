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
@Table(name = "tms_user_task_assignment_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignmentLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "taskId")
	private Long taskId;
	@Column(name = "LA")
	private String LA;
	@Column(name = "assigned_to")
	private Long assignedTo;
	@Column(name = "assigned_date")
	private LocalDate assignedDate;
	@Column(name = "assigned_by")
	private Long assignedBy;
	@Column(name = "previous_assigned_to")
	private Long previousAssignedTo;
	@Column(name = "previous_assigned_date")
	private LocalDate previousAssignedDate;
	@Column(name = "previous_assigned_by")
	private Long previousAssignedBy;
	@Column(name = "current_owner")
	private Long currentOwner;
	@Column(name = "previous_owner")
	private Long previousOwner;
	@Column(name = "current_status")
	private Integer currentStatus;
	@Column(name = "previous_status")
	private Integer previousStatus;
	@Column(name = "createdBy")
	private Long createdBy;
	@Column(name = "creationDate")
	private LocalDate creationDate;
	@Column(name = "jobStartDate")
	private LocalDate jobStartDate;
	@Column(name = "jobEndDate")
	private LocalDate jobEndDate;
}