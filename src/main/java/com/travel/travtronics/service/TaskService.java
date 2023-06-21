package com.travel.travtronics.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.travel.travtronics.helper.DataConverter;
import com.travel.travtronics.helper.TaskAssginmentAuditConverter;
import com.travel.travtronics.model.AssignmentLog;
import com.travel.travtronics.model.Audit;
import com.travel.travtronics.model.ClosedMahaReportRequestModel;
import com.travel.travtronics.model.DMSModel;
import com.travel.travtronics.model.MahaReportRequestModel;
import com.travel.travtronics.model.Task;
import com.travel.travtronics.model.TaskTemp;
import com.travel.travtronics.repository.AssignmentLogRepository;
import com.travel.travtronics.repository.AuditRepository;
import com.travel.travtronics.repository.CustomTaskRepository;
import com.travel.travtronics.repository.DMSModelRepository;
import com.travel.travtronics.repository.TaskRepository;
import com.travel.travtronics.repository.TaskTempRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.DMSResponseModel;
import com.travel.travtronics.response.MessageResponse;
import com.travel.travtronics.response.ResponseDtoModel;
import com.travel.travtronics.response.TaskRequest;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	TaskTempRepository taskTempRepository;

	@Autowired
	AuditRepository auditRepository;

	@Autowired
	AssignmentLogRepository assignmentLogRepository;

	public APIResponse createTask(Task task) {
		List<Task> list = new ArrayList<>();
		try {
			Task save = taskRepository.save(task);
			auditRepository.save(DataConverter.converterTasktoAudit(save));
			assignmentLogRepository.save(DataConverter.converterTasktoAssignmentLog(save));
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse gettaskId(Long taskId) {
		List<Task> list = new ArrayList<>();
		try {
			Optional<Task> opt = taskRepository.findByTaskId(taskId);
			if (opt.isPresent()) {
				list.add(opt.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getName(String name) {
		List<Task> list = new ArrayList<>();
		try {
			Optional<Task> opt = taskRepository.findByname(name);
			if (opt.isPresent()) {
				list.add(opt.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getcreatedBy(String createdBy) {
		try {
			List<Map<String, String>> list = taskRepository.findBycreatedBy(createdBy);
			if (!list.isEmpty()) {
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}

	}

	@Deprecated
	public APIResponse getedit(Task task) {
		List<Task> list = new ArrayList<>();
		try {
			Optional<Task> opt = taskRepository.findByTaskId(task.getTaskId());
			if (opt.isPresent()) {
				task.setCreatedBy(opt.get().getCreatedBy());
				Task save = taskRepository.save(task);
				list.add(save);
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getAll() {
		try {
			// List<Task> list = taskRepository.findAll();
			List<Map<String, String>> list = taskRepository.findAllByList();
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getTypeByTask(String type) {
		try {
			List<Task> list = taskRepository.findAllByType(type);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getCategoryByTask(String category) {
		try {
			List<Task> list = taskRepository.findAllByCategory(category);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getStatusByTask(String status) {
		try {
			List<Task> list = taskRepository.findAllByStatus(status);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse names(String name) {
		try {
			List<Map<String, Object>> list = taskRepository.findBynames(name);
			if (!list.isEmpty()) {
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.NOT_FOUND.name(),
					new ArrayList<>());
		}
	}

	public MessageResponse deleteid(Long taskId) {
		Optional<Task> opt = taskRepository.findByTaskId(taskId);
		if (opt.isPresent()) {
			taskRepository.deleteById(taskId);
			return new MessageResponse(HttpStatus.OK.value(), String.format("you have delete the taskid:%d", taskId));
		}
		return new MessageResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
	}

	public MessageResponse deleteList() {
		try {
			taskRepository.deleteAll();
			return new MessageResponse(HttpStatus.OK.value(), String.format("You have Sucessfully deleted the list"));
		} catch (Exception ex) {
			ex.printStackTrace();
			return new MessageResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.name());
		}
	}

	public APIResponse getwiw(Long wiw) {
//		List<Task> list = new ArrayList<>();
		try {
			List<Task> opt = taskRepository.findWiwList(wiw);
			if (!opt.isEmpty()) {
//				list.add(opt.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getwiwandpriority(Long wiw, String priority) {
		try {
			List<Task> opt = taskRepository.findByWiwAndPriority(wiw, priority);
			if (!opt.isEmpty()) {
//				list.add(opt.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getpriorityAndCreatedBy(String priority, String createdBy) {
		try {
			List<Task> opt = taskRepository.findByPriorityAndCreatedBy(priority, createdBy);
			if (!opt.isEmpty()) {
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getownerAndpriority(String owner, String priority) {
		try {
			List<Task> opt = taskRepository.findByownerAndPriority(owner, priority);
			if (!opt.isEmpty()) {
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getowner(String owner) {
		try {
			List<Task> list = taskRepository.findByowner(owner);
			if (!list.isEmpty()) {
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getpriority(String priority) {
		try {
			List<Task> opt = taskRepository.findBypriority(priority);
			if (!opt.isEmpty()) {
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getcloseingTodayTask(Long wiw) {
		try {
			List<Task> opt = taskRepository.findByClosingTodayTasks(wiw);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}

	}

	public APIResponse getcloseingTomarrowTasks(Long wiw) {
		try {
			List<Task> list = taskRepository.findByClosingTomorrowTask(wiw);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getcloseingYesterdayTasks(Long wiw) {
		try {
			List<Task> list = taskRepository.findByClosingYesterdayTask(wiw);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getunplanedTasks(Long wiw) {
		try {
			List<Task> list = taskRepository.findByunplanedTasks(wiw);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse putinfo(Long wiw, String owner, Long projectId) {

		if (wiw != null && owner == null && projectId == null) {
			List<Task> list = taskRepository.findByWiw(wiw);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);

		} else if (wiw == null && owner != null && projectId == null) {
			List<Task> list = taskRepository.findByOwner(owner);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} else if (wiw == null && owner == null && projectId != null) {
			List<Task> list = taskRepository.findByprojectId(projectId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);

		} else if (wiw != null && owner != null && projectId == null) {
			List<Task> list = taskRepository.findByWiwAndOwner(wiw, owner);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} else if (wiw == null && owner != null && projectId != null) {
			List<Task> list = taskRepository.findByownerAndProjectId(owner, projectId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} else if (wiw != null && owner == null && projectId != null) {
			List<Task> list = taskRepository.findBywiwAndprojectId(wiw, projectId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} else if (wiw != null && owner != null && projectId != null) {
			List<Task> list = taskRepository.findByWiwAndOwnerAndProjectId(wiw, owner, projectId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	@Autowired
	CustomTaskRepository custTaskRepo;

	public APIResponse mahasearch(String description, Long wiw, String status, String owner, String priority,
			String urgency, LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate,
			LocalDate plannedEndDate, Long projectId, LocalDate createdDate, String createdBy) {

		List<Task> mahasearch = custTaskRepo.mahasearch(description, wiw, status, owner, priority, urgency,
				jobStartDate, jobEndDate, plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), mahasearch);
	}

	public APIResponse mahaclosedsearch(String description, Long wiw, String status, String owner, String priority,
			String urgency, LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate,
			LocalDate plannedEndDate, Long projectId, LocalDate createdDate, String createdBy) {

		List<Task> mahaclosedsearch = custTaskRepo.mahasearch(description, wiw, status, owner, priority, urgency,
				jobStartDate, jobEndDate, plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), mahaclosedsearch);
	}

	public APIResponse opentasksearch(String description, Long wiw, String status, String owner, String priority,
			String urgency, LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate,
			LocalDate plannedEndDate, Long projectId, LocalDate createdDate, String createdBy) {

		List<Task> opentasksearch = custTaskRepo.mahasearch(description, wiw, status, owner, priority, urgency,
				jobStartDate, jobEndDate, plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opentasksearch);
	}

	public APIResponse closedtasksearch(String description, Long wiw, String status, String owner, String priority,
			String urgency, LocalDate jobStartDate, LocalDate jobEndDate, LocalDate plannedStartDate,
			LocalDate plannedEndDate, Long projectId, LocalDate createdDate, String createdBy) {

		List<Task> opentasksearch = custTaskRepo.mahasearch(description, wiw, status, owner, priority, urgency,
				jobStartDate, jobEndDate, plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opentasksearch);
	}

	public APIResponse allDto() {
		List<TaskTemp> opt = taskTempRepository.findAll();
		List<ResponseDtoModel> collect = opt.stream().filter(model -> Objects.isNull(model.getStatusRecord()))
				.map(model -> {
					ResponseDtoModel response = new ResponseDtoModel();
					ResponseEntity<?> craeteLogTask = createLogTaskAdv(DataConverter.converterTaskTemptoTask((model)));
					if (craeteLogTask.getStatusCodeValue() == 200) {
						model.setStatusRecord(true);
						response.setLogStatus(true);
						response.setOrigionalTaskId(model.getTaskTempId());
						response.setLogTaskInfo(craeteLogTask.getBody());
						taskTempRepository.save(model);

					} else {
						model.setStatusRecord(false);
						response.setOrigionalTaskId(model.getTaskTempId());
						taskTempRepository.save(model);

					}
					return response;
				}).collect(Collectors.toList());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
	}

	public ResponseEntity<Task> createLogTaskAdv(Task model) {
		try {
			Task save = taskRepository.save(model);
			auditRepository.save(DataConverter.converterTasktoAudit(save));
			assignmentLogRepository.save(DataConverter.converterTasktoAssignmentLog(save));
			return new ResponseEntity<Task>(save, HttpStatus.OK);
			// return
			// ResponseEntity.status(HttpStatus.OK).body(taskAdvRepository.save(model));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse modifyTaskInfo(@Valid TaskRequest task, Long taskId) {

		/*
		 * task validation
		 */
		Optional<Task> taskValidation = taskRepository.findByTaskId(taskId);
		if (!taskValidation.isPresent()) {
			return new APIResponse(HttpStatus.OK.value(), "invalid-task-information-received", Collections.emptyList());
		}

		/*
		 * insert a task info in assginment model
		 */
		if (task.getUserChanged() != null && task.getUserChanged() != 0 && task.getUserChanged() == 1) {
			taskAssinmentInfo(task, taskId, taskValidation.get());
		}

		/*
		 * insert a task info in audit model
		 */

		taskAuditInfo("update", task, taskId);

		/*
		 * modify original taskInfo
		 */
		logger.info("-------------------------task-modification-initialized-------------------------------");

		Task savedTask = taskRepository.save(TaskAssginmentAuditConverter.mapTaskRequestToEntity(task, taskId));

		logger.info("-------------------------task-modification-completed-------------------------------");

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(savedTask));

	}

	public void taskAssinmentInfo(TaskRequest currentTaskInfo, Long taskId, Task previousTaskInfo) {
		logger.info("-------------------------task-assignment-initialized-------------------------------");
		AssignmentLog prepareTaskAssignmentInfo = TaskAssginmentAuditConverter
				.prepareTaskAssignmentInfo(currentTaskInfo, taskId, previousTaskInfo);
		assignmentLogRepository.save(prepareTaskAssignmentInfo);
		logger.info("-------------------------task-assignment-completed-------------------------------");
	}

	public void taskAuditInfo(String auditAction, TaskRequest taskRequest, Long taskId) {
		logger.info("-------------------------task-audit-initialized-------------------------------");
		Audit prepareTaskAuditInfo = TaskAssginmentAuditConverter.prepareTaskAuditInfo(auditAction, taskRequest,
				taskId);
		auditRepository.save(prepareTaskAuditInfo);
		logger.info("-------------------------task-audit-completed-------------------------------");
	}

	public APIResponse mahaSearch(@Valid MahaReportRequestModel filters) {

		if (filters.getDescription() == null && filters.getWiw() == null && filters.getStatusId() == null
				&& filters.getOwner() == null && filters.getPriority() == null && filters.getUrgency() == null
				&& filters.getJobStartDate() == null && filters.getJobEndDate() == null
				&& filters.getPlannedStartDate() == null && filters.getPlannedEndDate() == null
				&& filters.getProjectId() == null && filters.getCreatedBy() == null
				&& filters.getCreatedDate() == null) {
			return new APIResponse(HttpStatus.BAD_REQUEST.value(), "invalid-request-check-request-body-formatting",
					Collections.emptyList());
		}

		/*
		 * intializing filters wtih default values
		 */
		String description = null;

		Integer wiw = 0;

		Integer statusId = 0;

		Integer owner = 0;

		String priority = null;

		String urgency = null;

		LocalDate jobStartDate = null;

		LocalDate jobEndDate = null;

		LocalDate plannedStartDate = null;

		LocalDate plannedEndDate = null;

		Integer projectId = 0;

		Integer createdBy = 0;

		LocalDate createdDate = null;

		/*
		 * validate filters
		 */
		logger.info("--------------------filters-validations-intialized------------------------");
		if (Objects.nonNull(filters.getDescription()) && !filters.getDescription().isBlank())
			description = filters.getDescription();
		if (filters.getWiw() != null && filters.getWiw() != 0)
			wiw = filters.getWiw();
		if (filters.getStatusId() != null && filters.getStatusId() != 0)
			statusId = filters.getStatusId();
		if (filters.getOwner() != null && filters.getOwner() != 0)
			owner = filters.getOwner();
		if (Objects.nonNull(filters.getJobStartDate()))
			jobStartDate = filters.getJobStartDate();
		if (Objects.nonNull(filters.getJobEndDate()))
			jobEndDate = filters.getJobEndDate();
		if (Objects.nonNull(filters.getPlannedStartDate()))
			plannedStartDate = filters.getPlannedStartDate();
		if (Objects.nonNull(filters.getPlannedEndDate()))
			plannedEndDate = filters.getPlannedEndDate();
		if (filters.getProjectId() != null && filters.getProjectId() != 0)
			projectId = filters.getProjectId();
		if (filters.getCreatedBy() != null && filters.getCreatedBy() != 0)
			createdBy = filters.getCreatedBy();
		if (Objects.nonNull(filters.getCreatedDate()))
			createdDate = filters.getCreatedDate();
		if (filters.getPriority() != null && !filters.getPriority().isBlank())
			priority = filters.getPriority();
		if (filters.getUrgency() != null && !filters.getUrgency().isBlank())
			urgency = filters.getUrgency();
		logger.info("--------------------filters-validations-completed------------------------");
		List<Map<String, String>> searchMahaReport = taskRepository.searchMahaReport(description, wiw, statusId, owner,
				priority, urgency, jobStartDate, jobEndDate, plannedStartDate, plannedEndDate, projectId, createdBy,
				createdDate);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), searchMahaReport);
	}

	public APIResponse mahaClosedSearch(@Valid ClosedMahaReportRequestModel filters) {

		if (filters.getDescription() == null && filters.getWiw() == null && filters.getStatus() == null
				&& filters.getTeamId() == null && filters.getPriority() == null && filters.getUrgency() == null
				&& filters.getClosedDateFrom() == null && filters.getClosedDateTo() == null
				&& filters.getAssingedDateFrom() == null && filters.getAssingedDateTo() == null
				&& filters.getProject() == null && filters.getTaskId() == null) {
			return new APIResponse(HttpStatus.BAD_REQUEST.value(), "invalid-request-check-request-body-formatting",
					Collections.emptyList());
		}

		/*
		 * intializing filters wtih default values
		 */
		Integer taskId = 0;

		String description = null;

		Integer wiw = 0;

		Integer statusId = 0;

		Integer team = 0;

		String priority = null;

		String urgency = null;

		LocalDate closedDateFrom = null;

		LocalDate closedDateTo = null;

		LocalDate assingedDateFrom = null;

		LocalDate assingedDateTo = null;

		Integer projectId = 0;

		/*
		 * validate filters
		 */
		logger.info("--------------------filters-validations-intialized------------------------");

		if (filters.getTaskId() != null && filters.getTaskId() != 0)
			taskId = filters.getTaskId();
		if (filters.getDescription() != null && !filters.getDescription().isBlank())
			description = filters.getDescription();
		if (filters.getWiw() != null && filters.getWiw() != 0)
			wiw = filters.getWiw();
		if (filters.getStatus() != null && filters.getStatus() != 0)
			statusId = filters.getStatus();
		if (filters.getTeamId() != null && filters.getTeamId() != 0)
			team = filters.getTeamId();
		if (filters.getPriority() != null && !filters.getPriority().isBlank())
			priority = filters.getPriority();
		if (filters.getUrgency() != null && !filters.getUrgency().isBlank())
			urgency = filters.getUrgency();
		if (Objects.nonNull(filters.getClosedDateFrom()))
			closedDateFrom = filters.getClosedDateFrom();
		if (Objects.nonNull(filters.getClosedDateTo()))
			closedDateTo = filters.getClosedDateTo();
		if (Objects.nonNull(filters.getAssingedDateFrom()))
			assingedDateFrom = filters.getAssingedDateFrom();
		if (Objects.nonNull(filters.getAssingedDateTo()))
			assingedDateTo = filters.getAssingedDateTo();
		if (filters.getProject() != null && filters.getProject() != 0)
			projectId = filters.getProject();
		logger.info("--------------------filters-validations-completed------------------------");

		List<Map<String, String>> closedMahaSearch = taskRepository.closedMahaSearch(taskId, description, wiw, statusId,
				team, priority, urgency, closedDateFrom, closedDateTo, assingedDateFrom, assingedDateTo, projectId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), closedMahaSearch);
	}

	public APIResponse getViewDefaultStatusForTask(String category, String type, Long milestoneId, Long projectId) {
		try {
			List<Map<String, String>> list = taskRepository.findAllByLists();
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public ResponseEntity storeElement(String entityId, MultipartFile multiPartFile) throws IOException {
		try {

			File file = new File(multiPartFile.getOriginalFilename().contains(" ")
					? multiPartFile.getOriginalFilename().replaceAll(" ", "-")
					: multiPartFile.getOriginalFilename());

			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multiPartFile.getBytes());
			fos.close();

			String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1).trim();

			uploadFileToS3Bucket(entityId + "." + extension, file);

			file.delete();

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Autowired
	AmazonS3 amazonS3Client;
	
	@Autowired
	DMSModelRepository dmsModelRepository;	
	
	@Value("${com.travel.travtronics.cdn.url}")
	private String cdnUrl;

	@Value("${com.travel.travtronics.uploader.bucketName}")
	private String bucketName;

	private void uploadFileToS3Bucket(String fileName, File file) {
		amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
	}
	
	public ResponseEntity<?> storeElementNew(String entityId, String entityType, MultipartFile multiPartFile)
			throws IOException {
		try {

			Optional<DMSModel> previousDoc = dmsModelRepository.findTopByEntityTypeAndEntityIdOrderByDocId(entityType,
					entityId);
			String entityName = null;

			File file = new File(multiPartFile.getOriginalFilename().contains(" ")
					? multiPartFile.getOriginalFilename().replaceAll(" ", "-")
					: multiPartFile.getOriginalFilename());

			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multiPartFile.getBytes());
			fos.close();

			String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1).trim();

			if (previousDoc.isPresent()) {
				String previousEntityName = previousDoc.get().getEntityName();
				Integer count = Integer.parseInt(previousEntityName.substring(0, previousEntityName.lastIndexOf(".")))
						+ 1;
				entityName = count.toString() + "." + extension;
			} else {
				entityName = "1" + "." + extension;
			}

			uploadFileToS3Bucket(entityType + "/" + entityId + "/" + entityName, file);

			DMSModel dmsModel = new DMSModel(entityType, entityId, entityName);
			dmsModelRepository.save(dmsModel);

			DMSResponseModel response = new DMSResponseModel(entityName,
					cdnUrl + entityType + "/" + entityId + "/" + entityName);
			file.delete();

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}