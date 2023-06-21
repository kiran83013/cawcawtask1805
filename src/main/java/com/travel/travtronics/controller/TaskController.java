package com.travel.travtronics.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travel.travtronics.model.ClosedMahaReportRequestModel;
import com.travel.travtronics.model.ExcelToTaskTemp;
import com.travel.travtronics.model.MahaReportRequestModel;
import com.travel.travtronics.model.Task;
import com.travel.travtronics.repository.ExcelToTaskTempRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.TaskRequest;
import com.travel.travtronics.service.TaskService;

@RestController
@RequestMapping("/task")
@Validated
@CrossOrigin
public class TaskController {

	@Autowired
	TaskService taskService;

	@Autowired
	ExcelToTaskTempRepository excelToTaskTempRepository;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@GetMapping(value = "/id", produces = "application/json")
	public APIResponse getId(@RequestParam Long taskId) {
		return taskService.gettaskId(taskId);
	}

	@GetMapping(value = "/getTypeByTask", produces = "application/json")
	public APIResponse getTypeByTask(@RequestParam String type) {
		return taskService.getTypeByTask(type);
	}

	@GetMapping(value = "/getCategoryByTask", produces = "application/json")
	public APIResponse getCategoryByTask(@RequestParam String category) {
		return taskService.getCategoryByTask(category);
	}

	@GetMapping(value = "/getStatusByTask", produces = "application/json")
	public APIResponse getStatusByTask(@RequestParam String status) {
		return taskService.getStatusByTask(status);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll() {
		return taskService.getAll();
	}
	
	/*As per Bhargavi Requirment*/
	@PostMapping(value = "/viewDefaultStatusForTask", produces = "application/json")
	public APIResponse getViewDefaultStatusForTask(@RequestParam String category, @RequestParam String type, @RequestParam Long milestoneId, @RequestParam Long projectId) {
		return taskService.getViewDefaultStatusForTask(category,type,milestoneId,projectId);
	}

//	@GetMapping(value = "/allnames", produces = "application/json")
//	public APIResponse names(@RequestParam String name) {
//		return taskService.names(name);
//	}

//	@DeleteMapping(value = "/deleteid", produces = "application/json")
//	public MessageResponse deleteid(@RequestParam Long tsakId) {
//		return taskService.deleteid(tsakId);
//	}
//
//	@DeleteMapping(value = "/deletelist")
//	public MessageResponse deleteList() {
//		return taskService.deleteList();
//	}

	@GetMapping(value = "/wiw", produces = "application/json")
	public APIResponse getwiw(@RequestParam Long wiw) {
		return taskService.getwiw(wiw);
	}

	@GetMapping(value = "/wiwAndPriority", produces = "application/json")
	public APIResponse getwiwandpriority(@RequestParam Long wiw, @RequestParam String priority) {
		return taskService.getwiwandpriority(wiw, priority);
	}

	@GetMapping(value = "/priorityAndcreatedBy", produces = "application/json")
	public APIResponse getpriorityAndCreatedBy(@RequestParam String priority, @RequestParam String createdBy) {
		return taskService.getpriorityAndCreatedBy(priority, createdBy);
	}

	@GetMapping(value = "/ownerAndPriority", produces = "application/json")
	public APIResponse getownerAndpriority(@RequestParam String owner, @RequestParam String priority) {
		return taskService.getownerAndpriority(owner, priority);
	}

	@GetMapping(value = "/owner", produces = "application/json")
	public APIResponse getowner(@RequestParam String owner) {
		return taskService.getowner(owner);
	}

	@GetMapping(value = "/priority", produces = "application/json")
	public APIResponse getpriority(@RequestParam String priority) {
		return taskService.getpriority(priority);
	}

	@GetMapping(value = "/closingTodayTask", produces = "application/json")
	public APIResponse getcloseingTodayTask(@RequestParam Long wiw) {
		return taskService.getcloseingTodayTask(wiw);
	}

	@GetMapping(value = "/closingTomarrowTask", produces = "application/json")
	public APIResponse getcloseingTomarrowTasks(@RequestParam Long wiw) {
		return taskService.getcloseingTomarrowTasks(wiw);
	}

	@GetMapping(value = "/closingYesterdayTasks", produces = "application/json")
	public APIResponse getcloseingYesterdayTasks(@RequestParam Long wiw) {
		return taskService.getcloseingYesterdayTasks(wiw);
	}

	@GetMapping(value = "/unplanedTasks", produces = "application/json")
	public APIResponse getunplanedTasks(@RequestParam Long wiw) {
		return taskService.getunplanedTasks(wiw);
	}

	@GetMapping(value = "/putinfo", produces = "application/json")
	public APIResponse putinfo(@RequestParam(required = false) Long wiw, @RequestParam(required = false) String owner,
			@RequestParam(required = false) Long projectId) {
		return taskService.putinfo(wiw, owner, projectId);
	}
	/*
	 * commentting by kalyan due incorrect code
	 */
//	@GetMapping(value = "/maha", produces = "application/json")
//	public APIResponse mahasearch(@RequestParam(required = false) String description,
//			@RequestParam(required = false) Long wiw, @RequestParam(required = false) String status,
//			@RequestParam(required = false) String owner, @RequestParam(required = false) String priority,
//			@RequestParam(required = false) String urgency,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobEndDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedEndDate,
//			@RequestParam(required = false) Long projectId,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdDate,
//			@RequestParam(required = false) String createdBy) {
//		return taskService.mahasearch(description, wiw, status, owner, priority, urgency, jobStartDate, jobEndDate,
//				plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);
//	}
//
//	@GetMapping(value = "/mahaclosedsearch", produces = "application/json")
//	public APIResponse mahaclosedsearch(@RequestParam(required = false) String description,
//			@RequestParam(required = false) Long wiw, @RequestParam(required = false) String status,
//			@RequestParam(required = false) String owner, @RequestParam(required = false) String priority,
//			@RequestParam(required = false) String urgency,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobEndDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedEndDate,
//			@RequestParam(required = false) Long projectId,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdDate,
//			@RequestParam(required = false) String createdBy) {
//		return taskService.mahaclosedsearch(description, wiw, status, owner, priority, urgency, jobStartDate,
//				jobEndDate, plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);
//	}
//
//	@GetMapping(value = "/opentasksearch", produces = "application/json")
//	public APIResponse opentasksearch(@RequestParam(required = false) String description,
//			@RequestParam(required = false) Long wiw, @RequestParam(required = false) String status,
//			@RequestParam(required = false) String owner, @RequestParam(required = false) String priority,
//			@RequestParam(required = false) String urgency,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobEndDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedEndDate,
//			@RequestParam(required = false) Long projectId,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdDate,
//			@RequestParam(required = false) String createdBy) {
//		return taskService.opentasksearch(description, wiw, status, owner, priority, urgency, jobStartDate, jobEndDate,
//				plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);
//	}
//
//	@GetMapping(value = "/closedtasksearch", produces = "application/json")
//	public APIResponse closedtasksearch(@RequestParam(required = false) String description,
//			@RequestParam(required = false) Long wiw, @RequestParam(required = false) String status,
//			@RequestParam(required = false) String owner, @RequestParam(required = false) String priority,
//			@RequestParam(required = false) String urgency,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jobEndDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedStartDate,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate plannedEndDate,
//			@RequestParam(required = false) Long projectId,
//			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdDate,
//			@RequestParam(required = false) String createdBy) {
//		return taskService.closedtasksearch(description, wiw, status, owner, priority, urgency, jobStartDate,
//				jobEndDate, plannedStartDate, plannedEndDate, projectId, createdDate, createdBy);
//	}

	@GetMapping(value = "dataMigration-temp-to-task", produces = "application/json")
	public APIResponse allDto() {
		return taskService.allDto();
	}

	@RequestMapping(value = "/import-excelData-Temp-to-Task", method = RequestMethod.POST)
	public ResponseEntity<List<ExcelToTaskTemp>> importExcelTempFile(@RequestParam("file") MultipartFile files)
			throws IOException {
		HttpStatus status = HttpStatus.OK;
		List<ExcelToTaskTemp> productList = new ArrayList<>();

		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {
				ExcelToTaskTemp product = new ExcelToTaskTemp();

				XSSFRow row = worksheet.getRow(index);
				Long id = (long) row.getCell(0).getNumericCellValue();
				System.out.println("id");
				product.setTaskId(id.longValue());
				System.out.println("taskid");
				product.setParentTaskId((long) row.getCell(1).getNumericCellValue());
				System.out.println("setParentTaskId");
				product.setMileStoneId((long) row.getCell(2).getNumericCellValue());
				System.out.println("setMileStoneId");
				product.setProjectId((long) row.getCell(3).getNumericCellValue());
				System.out.println("setProjectId");
				product.setDepartmentId((long) row.getCell(4).getNumericCellValue());
				System.out.println("setDepartmentId");
				product.setName(row.getCell(5).getStringCellValue());
				System.out.println("setName");
				product.setCategory((long) row.getCell(6).getNumericCellValue());
				System.out.println("setCategory");
				product.setType((long) row.getCell(7).getNumericCellValue());
				System.out.println("setType");
				product.setStatus((long) row.getCell(8).getNumericCellValue());
				System.out.println("setStatus");
				product.setOwner((long) row.getCell(9).getNumericCellValue());
				System.out.println("setOwner");
				product.setOwnerType(row.getCell(10).getStringCellValue());
				System.out.println("setOwnerType");
				product.setWiw((long) row.getCell(11).getNumericCellValue());
				System.out.println("setWiw");
				product.setSummary(row.getCell(12).getStringCellValue());
				System.out.println("setSummary");
				product.setDescription(row.getCell(13).getStringCellValue());
				System.out.println("setDescription");
				product.setPlannedStartDate(row.getCell(14).getDateCellValue());
				System.out.println("setPlannedStartDate");
				product.setPlannedEndDate(row.getCell(15).getDateCellValue());
				System.out.println("setPlannedEndDate");
				product.setActualStartDate(row.getCell(16).getDateCellValue());
				System.out.println("setActualStartDate");
				product.setActualEndDate(row.getCell(17).getDateCellValue());
				System.out.println("setActualEndDate");
				product.setJobStartDate(row.getCell(18).getDateCellValue());
				System.out.println("setJobStartDate");
				product.setJobEndDate(row.getCell(19).getDateCellValue());
				System.out.println("setJobEndDate");
				product.setAttachments(row.getCell(20).getStringCellValue());
				System.out.println("setAttachments");
				product.setNotes(row.getCell(21).getStringCellValue());
				System.out.println("setNotes");
				product.setPriority(row.getCell(22).getStringCellValue());
				System.out.println("setPriority");
				product.setUrgency(row.getCell(23).getStringCellValue());
				System.out.println("setUrgency");
				product.setCreatedBy((long) row.getCell(24).getNumericCellValue());
				System.out.println("setCreatedBy");
				product.setCreatedDate(row.getCell(25).getDateCellValue());
				System.out.println("setCreatedDate");
				product.setAssignedDate(row.getCell(26).getDateCellValue());
				System.out.println("setAssignedDate");
				product.setUpdateBy((long) row.getCell(27).getNumericCellValue());
				System.out.println("setUpdateBy");
				product.setUpdatedDate(row.getCell(28).getDateCellValue());
				System.out.println("setUpdatedDate");
				product.setRecordStatus((long) row.getCell(29).getNumericCellValue());
				System.out.println("setRecordStatus");
//				product.setRefId((long)row.getCell(30).getNumericCellValue());
//				System.out.println("setRefId");
//				product.setRefType(((long)row.getCell(31).getNumericCellValue()));
//				System.out.println("setRefType");				
//				product.setStatusRecord ((long)row.getCell(32).getNumericCellValue());
//				System.out.println("setStatusRecord");
				excelToTaskTempRepository.save(product);
				productList.add(product);
			}
		}
		return new ResponseEntity<>(productList, status);
	}

	/*
	 * @Param taskId
	 * 
	 * @Param TaskRequest Entity
	 * 
	 * @Return Original Task Entity
	 */
	@PutMapping(value = "/modify-task-info/{taskId}", consumes = "application/json", produces = "application/json")
	public APIResponse modifyTaskInfo(@RequestBody @Valid TaskRequest task, @PathVariable Long taskId) {
		return taskService.modifyTaskInfo(task, taskId);

	}

	/*
	 * @Param MahaReportRequestModel
	 * 
	 * @Return Map as Results
	 */
	@PostMapping(value = "/maha-search-report", consumes = "application/json", produces = "application/json")
	public APIResponse mahaSearch(@RequestBody @Valid MahaReportRequestModel filters) {
		return taskService.mahaSearch(filters);
	}
	
	/*
	 * @Param CloasedMahaReportRequestModel
	 * 
	 * @Return Map as Results
	 */
	@PostMapping(value = "/closed-maha-search-report", consumes = "application/json", produces = "application/json")
	public APIResponse mahaClosedSearch(@RequestBody @Valid ClosedMahaReportRequestModel filters) {
		return taskService.mahaClosedSearch(filters);
	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, value = "/upload-file")
	public ResponseEntity uploadElement(@RequestParam("entityId") String entityId,
			@RequestParam("file") MultipartFile file) throws IOException {
		return taskService.storeElement(entityId, file);
	}
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, value = "/upload-file-type")
	public ResponseEntity uploadElementType(@RequestParam("entityId") String entityId, String entityType,
			@RequestParam("file") MultipartFile file) throws IOException {
		return taskService.storeElementNew(entityId, entityType, file);
	}


}