package com.travel.travtronics.response;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequest {

	private Long parentTaskId;

	private Long mileStoneId;

	@NotNull(message = "project should not be null")
	private Long projectId;

	private Long departmentId;

	private String name;

	private String category;

	private String type;

	@NotNull(message = "status should notbe null")
	private String status;

	private String owner;

	private String ownerType;

	@NotNull(message = "wiw should not be null")
	private Long wiw;

	private String summary;

	private String description;

	private LocalDate plannedStartDate;

	private LocalDate plannedEndDate;

	private LocalDate actualStartDate;

	private LocalDate actualEndDate;

	private LocalDate jobStartDate;

	private LocalDate jobEndDate;

	private String attachments;

	private String notes;

	@NotEmpty(message = "priority should not be empty or null")
	private String priority;

	@NotEmpty(message = "urgency should not be empty or null")
	private String urgency;

	private String createdBy;

	private LocalDate createdDate;

	private LocalDate assignedDate;

	@NotNull
	private String updateBy;

	private LocalDate updatedDate;

	private String recordStatus;
	
	private Integer userChanged;

}
