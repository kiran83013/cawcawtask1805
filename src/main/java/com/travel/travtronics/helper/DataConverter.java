package com.travel.travtronics.helper;

import com.travel.travtronics.model.AssignmentLog;
import com.travel.travtronics.model.Audit;
import com.travel.travtronics.model.Task;
import com.travel.travtronics.model.TaskTemp;

public class DataConverter {
		
public static Task converterTaskTemptoTask(TaskTemp taskTemp) {
		
	Task task = new Task();
	task.setActualEndDate(taskTemp.getActualEndDate());
	task.setActualStartDate(taskTemp.getActualStartDate());
	task.setAssignedDate(taskTemp.getAssignedDate());
	task.setAttachments(taskTemp.getAttachments());
	task.setCategory(taskTemp.getCategory());
	task.setCreatedBy(taskTemp.getCreatedBy());
	task.setCreatedDate(taskTemp.getCreatedDate());
	task.setDepartmentId(taskTemp.getDepartmentId());
	task.setDescription(taskTemp.getDescription());
	task.setJobEndDate(taskTemp.getJobEndDate());
	task.setJobStartDate(taskTemp.getJobStartDate());
	task.setMileStoneId(taskTemp.getMileStoneId());
	task.setName(taskTemp.getName());
	task.setNotes(taskTemp.getNotes());
	task.setOwner(taskTemp.getOwner());
	task.setOwnerType(taskTemp.getOwnerType());
	task.setParentTaskId(taskTemp.getParentTaskId());
	task.setPlannedEndDate(taskTemp.getPlannedEndDate());
	task.setPlannedStartDate(taskTemp.getPlannedStartDate());
	task.setPriority(taskTemp.getPriority());
	task.setProjectId(taskTemp.getProjectId());
	task.setRecordStatus(taskTemp.getRecordStatus());
	task.setStatus(taskTemp.getStatus());
	task.setSummary(taskTemp.getSummary());
	task.setType(taskTemp.getType());
	task.setUpdateBy(taskTemp.getUpdateBy());
	task.setUpdatedDate(taskTemp.getUpdatedDate());
	task.setUrgency(taskTemp.getUrgency());
	task.setWiw(Long.valueOf(taskTemp.getWiw()));
	task.setTaskId(taskTemp.getTaskTempId());
	return task;
		
	}

public static Audit converterTasktoAudit(Task task) {
	
	Audit auditModel = new Audit();
	auditModel.setActualEndDate(task.getActualEndDate());
	auditModel.setActualStartDate(task.getActualStartDate());
	auditModel.setAssignedDate(task.getAssignedDate());
	auditModel.setAttachments(task.getAttachments());
	auditModel.setCategory(task.getCategory());
	auditModel.setCreatedBy(task.getCreatedBy());
	auditModel.setCreatedDate(task.getCreatedDate());
	auditModel.setDepartmentId(task.getDepartmentId());
	auditModel.setDescription(task.getDescription());
	auditModel.setJobEndDate(task.getJobEndDate());
	auditModel.setJobStartDate(task.getJobStartDate());
	auditModel.setMilestoneId(task.getMileStoneId());
	auditModel.setName(task.getName());
	auditModel.setNotes(task.getNotes());
	auditModel.setOwner(task.getOwner());
	auditModel.setOwnerType(task.getOwnerType());
	auditModel.setParentTaskId(task.getParentTaskId());
	auditModel.setPlannedEndDate(task.getPlannedEndDate());
	auditModel.setPlannedStartDate(task.getPlannedStartDate());
	auditModel.setPriority(task.getPriority());
	auditModel.setProjectId(task.getProjectId());
	auditModel.setRecordStatus(task.getRecordStatus());
	auditModel.setStatus(Long.valueOf(task.getStatus()));
	auditModel.setSummary(task.getSummary());
	auditModel.setType(Long.valueOf(task.getType()));
	auditModel.setUpdateBy(task.getUpdateBy());
	auditModel.setUpdatedDate(task.getUpdatedDate());
	auditModel.setUrgency(task.getUrgency());
	auditModel.setWiw(Long.valueOf(task.getWiw()));
	auditModel.setTaskId(task.getTaskId());
	return auditModel;
		
	}

public static AssignmentLog converterTasktoAssignmentLog(Task task) {
	
	AssignmentLog assLogs = new AssignmentLog();
	assLogs.setTaskId(task.getTaskId());
	assLogs.setAssignedTo(task.getWiw());
	assLogs.setAssignedDate(task.getAssignedDate());
	assLogs.setAssignedBy(Long.valueOf(task.getUpdateBy()));
	assLogs.setPreviousAssignedTo(task.getWiw());
	assLogs.setPreviousAssignedDate(task.getAssignedDate());
	assLogs.setPreviousAssignedBy(Long.valueOf(task.getUpdateBy()));
	assLogs.setCurrentOwner(Long.valueOf(task.getOwner()));
	assLogs.setPreviousOwner(Long.valueOf(task.getOwner()));
	assLogs.setCurrentStatus(Integer.valueOf(task.getStatus()));
	assLogs.setPreviousStatus(Integer.valueOf(task.getStatus()));
	assLogs.setCreatedBy(Long.valueOf(task.getCreatedBy()));
	assLogs.setCreationDate(task.getCreatedDate());
	assLogs.setJobStartDate(task.getJobStartDate());
	assLogs.setJobEndDate(task.getJobEndDate());
	return assLogs;
	}
}
