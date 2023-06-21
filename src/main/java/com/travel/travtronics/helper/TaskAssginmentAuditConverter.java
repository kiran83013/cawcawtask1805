package com.travel.travtronics.helper;

import java.time.LocalDate;
import java.util.Objects;

import com.travel.travtronics.model.AssignmentLog;
import com.travel.travtronics.model.Audit;
import com.travel.travtronics.model.Task;
import com.travel.travtronics.response.TaskRequest;

public class TaskAssginmentAuditConverter {

	public static LocalDate todayDate = LocalDate.now();

	public static Task mapTaskRequestToEntity(TaskRequest taskRequest, Long taskId) {
		return Task.builder().taskId(taskId)
				.parentTaskId(Objects.nonNull(taskRequest.getParentTaskId()) ? taskRequest.getParentTaskId() : 0L)
				.mileStoneId(Objects.nonNull(taskRequest.getMileStoneId()) ? taskRequest.getMileStoneId() : 0L)
				.projectId(taskRequest.getProjectId())
				.departmentId(Objects.nonNull(taskRequest.getDepartmentId()) ? taskRequest.getDepartmentId() : 0L)
				.name(taskRequest.getName() != null ? taskRequest.getName() : null)
				.category(taskRequest.getCategory() != null ? taskRequest.getCategory() : null)
				.type(taskRequest.getType() != null ? taskRequest.getType() : null)
				.status(taskRequest.getStatus() != null ? taskRequest.getStatus() : null)
				.owner(taskRequest.getOwner() != null ? taskRequest.getOwner() : null)
				.ownerType(taskRequest.getOwnerType() != null ? taskRequest.getOwnerType() : null)
				.wiw(taskRequest.getWiw() != null ? taskRequest.getWiw() : 0L)
				.summary(taskRequest.getSummary() != null ? taskRequest.getSummary() : null)
				.plannedStartDate(
						Objects.nonNull(taskRequest.getPlannedStartDate()) ? taskRequest.getPlannedStartDate() : null)
				.plannedEndDate(
						Objects.nonNull(taskRequest.getPlannedEndDate()) ? taskRequest.getPlannedEndDate() : null)
				.actualStartDate(
						Objects.nonNull(taskRequest.getActualStartDate()) ? taskRequest.getActualStartDate() : null)
				.actualEndDate(Objects.nonNull(taskRequest.getActualEndDate()) ? taskRequest.getActualEndDate() : null)
				.jobStartDate(Objects.nonNull(taskRequest.getJobStartDate()) ? taskRequest.getJobStartDate() : null)
				.jobEndDate(Objects.nonNull(taskRequest.getJobEndDate()) ? taskRequest.getJobEndDate() : null)
				.attachments(taskRequest.getAttachments() != null ? taskRequest.getAttachments() : null)
				.notes(taskRequest.getNotes() != null ? taskRequest.getNotes() : null)
				.priority(taskRequest.getPriority()).urgency(taskRequest.getUrgency())
				.assignedDate(taskRequest.getAssignedDate())
				.updateBy(taskRequest.getUpdateBy() != null ? taskRequest.getUpdateBy() : "0").updatedDate(todayDate)
				.description(taskRequest.getDescription() != null ? taskRequest.getDescription() : null)
				.recordStatus(taskRequest.getRecordStatus() != null ? taskRequest.getRecordStatus() : null).build();
	}

	public static AssignmentLog prepareTaskAssignmentInfo(TaskRequest currentTaskInfo, Long taskId,
			Task previousTaskInfo) {
		return AssignmentLog.builder().taskId(taskId).assignedTo(currentTaskInfo.getWiw()).assignedDate(todayDate)
				.assignedBy(Long.valueOf(currentTaskInfo.getUpdateBy())).previousAssignedTo(previousTaskInfo.getWiw())
				.previousAssignedDate(previousTaskInfo.getAssignedDate())
				.previousAssignedBy(
						Objects.nonNull(previousTaskInfo.getUpdateBy()) ? Long.valueOf(previousTaskInfo.getUpdateBy())
								: Long.valueOf(previousTaskInfo.getCreatedBy()))
				.currentOwner(Long.valueOf(currentTaskInfo.getOwner()))
				.previousOwner(Long.valueOf(previousTaskInfo.getOwner()))
				.currentStatus(Integer.valueOf(currentTaskInfo.getStatus()))
				.previousStatus(Integer.valueOf(previousTaskInfo.getStatus())).creationDate(todayDate)
				.createdBy(previousTaskInfo.getUpdateBy() != null ? Long.valueOf(previousTaskInfo.getUpdateBy())
						: Long.valueOf(previousTaskInfo.getCreatedBy()))
				.jobStartDate(
						Objects.nonNull(previousTaskInfo.getJobStartDate()) ? previousTaskInfo.getJobStartDate() : null)
				.jobEndDate(Objects.nonNull(previousTaskInfo.getJobEndDate()) ? previousTaskInfo.getJobEndDate() : null)
				.build();
	}

	public static Audit prepareTaskAuditInfo(String auditAction, TaskRequest taskRequest, Long taskId) {
		return Audit.builder().taskId(taskId).auditAction(auditAction)
				.parentTaskId(Objects.nonNull(taskRequest.getParentTaskId()) ? taskRequest.getParentTaskId() : 0L)
				.milestoneId(Objects.nonNull(taskRequest.getMileStoneId()) ? taskRequest.getMileStoneId() : 0L)
				.projectId(taskRequest.getProjectId())
				.departmentId(Objects.nonNull(taskRequest.getDepartmentId()) ? taskRequest.getDepartmentId() : 0L)
				.name(taskRequest.getName() != null ? taskRequest.getName() : null)
				.category(taskRequest.getCategory() != null ? taskRequest.getCategory() : null)
				.type(taskRequest.getType() != null ? Long.valueOf(taskRequest.getType()) : null)
				.status(taskRequest.getStatus() != null ? Long.valueOf(taskRequest.getStatus()) : null)
				.owner(taskRequest.getOwner() != null ? taskRequest.getOwner() : null)
				.ownerType(taskRequest.getOwnerType() != null ? taskRequest.getOwnerType() : null)
				.wiw(taskRequest.getWiw() != null ? taskRequest.getWiw() : 0L)
				.summary(taskRequest.getSummary() != null ? taskRequest.getSummary() : null)
				.plannedStartDate(
						Objects.nonNull(taskRequest.getPlannedStartDate()) ? taskRequest.getPlannedStartDate() : null)
				.plannedEndDate(
						Objects.nonNull(taskRequest.getPlannedEndDate()) ? taskRequest.getPlannedEndDate() : null)
				.actualStartDate(
						Objects.nonNull(taskRequest.getActualStartDate()) ? taskRequest.getActualStartDate() : null)
				.actualEndDate(Objects.nonNull(taskRequest.getActualEndDate()) ? taskRequest.getActualEndDate() : null)
				.jobStartDate(Objects.nonNull(taskRequest.getJobStartDate()) ? taskRequest.getJobStartDate() : null)
				.attachments(taskRequest.getAttachments() != null ? taskRequest.getAttachments() : null)
				.notes(taskRequest.getNotes() != null ? taskRequest.getNotes() : null)
				.priority(taskRequest.getPriority()).urgency(taskRequest.getUrgency())
				.assignedDate(taskRequest.getAssignedDate())
				.updateBy(taskRequest.getUpdateBy() != null ? taskRequest.getUpdateBy() : "0").updatedDate(todayDate)
				.description(taskRequest.getDescription() != null ? taskRequest.getDescription() : null)
				.recordStatus(taskRequest.getRecordStatus() != null ? taskRequest.getRecordStatus() : null).build();
	}

}
