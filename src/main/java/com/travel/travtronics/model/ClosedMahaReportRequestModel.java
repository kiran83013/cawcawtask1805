package com.travel.travtronics.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClosedMahaReportRequestModel {
	
	private Integer taskId;
	
	private String description;
	
	private Integer wiw;
	
	private Integer status;
	
	private Integer teamId;
	
	private String priority;
	
	private String urgency;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate closedDateFrom;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate closedDateTo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate assingedDateFrom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate assingedDateTo;
	
	private Integer project;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getWiw() {
		return wiw;
	}

	public void setWiw(Integer wiw) {
		this.wiw = wiw;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public LocalDate getClosedDateFrom() {
		return closedDateFrom;
	}

	public void setClosedDateFrom(LocalDate closedDateFrom) {
		this.closedDateFrom = closedDateFrom;
	}

	public LocalDate getClosedDateTo() {
		return closedDateTo;
	}

	public void setClosedDateTo(LocalDate closedDateTo) {
		this.closedDateTo = closedDateTo;
	}

	public LocalDate getAssingedDateFrom() {
		return assingedDateFrom;
	}

	public void setAssingedDateFrom(LocalDate assingedDateFrom) {
		this.assingedDateFrom = assingedDateFrom;
	}

	public LocalDate getAssingedDateTo() {
		return assingedDateTo;
	}

	public void setAssingedDateTo(LocalDate assingedDateTo) {
		this.assingedDateTo = assingedDateTo;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}
	
	

}
