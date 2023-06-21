package com.travel.travtronics.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travel.travtronics.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findByTaskId(Long taskId);

	Optional<Task> findByname(String name);

	@Query(value = "select * from tms_user_task where createdBy=?", nativeQuery = true)
	List<Map<String, String>> findBycreatedBy(String createdBy);

	@Query(value = "select *from tms_user_task where name LIKE %?%", nativeQuery = true)
	List<Map<String, Object>> findBynames(String name);

	@Query(value = "select * from tms_user_task where wiw=?1", nativeQuery = true)
	List<Task> findWiwList(Long wiw);

	List<Task> findByWiwAndPriority(Long wiw, String priority);

	List<Task> findByPriorityAndCreatedBy(String priority, String createdBy);

	List<Task> findByownerAndPriority(String owner, String priority);

	List<Task> findByowner(String owner);

	List<Task> findBypriority(String priority);

	@Query(value = "SELECT * FROM tms_user_task WHERE wiw = ? AND DATE(jobEndDate) = CURDATE() ORDER BY AssignedDate;", nativeQuery = true)
	List<Task> findByClosingTodayTasks(Long wiw);

	@Query(value = "SELECT * FROM tms_user_task WHERE wiw = ? AND DATE(jobEndDate) = CURDATE()+1 ORDER BY AssignedDate;", nativeQuery = true)
	List<Task> findByClosingTomorrowTask(Long wiw);

	@Query(value = "SELECT * FROM tms_user_task WHERE wiw = ? AND DATE(jobEndDate) = CURDATE()-1 ORDER BY AssignedDate;", nativeQuery = true)
	List<Task> findByClosingYesterdayTask(Long wiw);

	@Query(value = "SELECT *FROM tms_user_task WHERE wiw IS NULL AND DATE(jobEndDate)IS NULL ORDER BY AssignedDate;", nativeQuery = true)
	List<Task> findByunplanedTasks(Long wiw);

	@Query(value = "SELECT *FROM tms_user_task  WHERE wiw= ?1", nativeQuery = true)
	List<Task> findByWiw(Long wiw);

	@Query(value = "SELECT *FROM tms_user_task  WHERE projectId= ?1", nativeQuery = true)
	List<Task> findByprojectId(Long projectId);

	@Query(value = "SELECT *FROM tms_user_task  WHERE wiw= ?1 AND OWNER =?2", nativeQuery = true)
	List<Task> findByWiwAndOwner(Long wiw, String owner);

	@Query(value = "SELECT *FROM tms_user_task  WHERE owner = ?1 AND projectid =?2", nativeQuery = true)
	List<Task> findByownerAndProjectId(String owner, Long projectId);

	@Query(value = "SELECT *FROM tms_user_task  WHERE wiw= ?1 AND projectid =?2", nativeQuery = true)
	List<Task> findBywiwAndprojectId(Long wiw, Long projectId);

	@Query(value = "SELECT *FROM tms_user_task WHERE wiw= ?1 AND OWNER = ?2 AND projectid =?3", nativeQuery = true)
	List<Task> findByWiwAndOwnerAndProjectId(Long wiw, String owner, Long projectId);

	@Query(value = "SELECT *FROM tms_user_task  WHERE owner= ?1", nativeQuery = true)
	List<Task> findByOwner(String owner);

	@Query(value = "SELECT t.taskId,\r\n" + "t.actualEndDate,\r\n" + "t.actualStartDate,\r\n" + "t.assignedDate,\r\n"
			+ "t.attachments,\r\n" + "t.createdDate,\r\n" + "t.description,\r\n" + "t.jobEndDate,\r\n"
			+ "t.jobStartDate,\r\n" + "t.name,\r\n" + "t.notes,\r\n" + "t.createdBy,\r\n" + "t.parentTaskId,\r\n"
			+ "t.plannedEndDate,\r\n" + "t.plannedStartDate,\r\n" + "t.recordStatus,\r\n" + "t.status,\r\n"
			+ "t.summary,\r\n" + "t.updatedBy,\r\n" + "t.upDatedDate,\r\n" + "t.category,\r\n"
			+ "c.name AS categoryName,\r\n" + "t.departmentId,\r\n" + "d.DepartmentName AS departmentName,\r\n"
			+ "t.milestoneId,\r\n" + "m.name AS mileStoneName,\r\n" + "t.owner,\r\n" + "tt.teamName AS ownerName,\r\n"
			+ "t.ownerType,\r\n" + "t.priority,\r\n" + "t.projectId,\r\n" + "pr.name AS projectName,\r\n"
			+ "t.type,\r\n" + "ty.name AS typeName,\r\n" + "t.Urgency AS urgencyName,\r\n" + "t.wiw,\r\n"
			+ "e.firstName AS wiwName\r\n" + "FROM tms_user_task t\r\n"
			+ "LEFT JOIN tms_admin_category_def c ON c.categoryId = t.category\r\n"
			+ "LEFT JOIN department d ON d.DepartmentId = t.departmentId\r\n"
			+ "LEFT JOIN tms_user_milestone m ON m.MileStoneId = t.milestoneId\r\n"
			+ "LEFT JOIN team tt ON tt.teamId = t.owner\r\n"
			+ "LEFT JOIN tms_user_project pr ON pr.ProjectId = t.projectId\r\n"
			+ "LEFT JOIN tms_admin_type ty ON ty.TypeId = t.type\r\n"
			+ "LEFT JOIN employee e ON e.id = t.wiw", nativeQuery = true)
	List<Map<String, String>> findAllByList();

	List<Task> findAllByType(String type);

	List<Task> findAllByCategory(String category);

	List<Task> findAllByStatus(String status);

	@Query(value = "{CALL maha_report(:description,:wiw,:statusId,:owner,:priority,:urgency,:jobStartDate,:jobEndDate,:plannedStartDate,:plannedEndDate,:projectId,:createdBy,:createdDate)}", nativeQuery = true)
	List<Map<String, String>> searchMahaReport(@Param("description") String description, @Param("wiw") Integer wiw,
			@Param("statusId") Integer statusId, @Param("owner") Integer owner, @Param("priority") String priority,
			@Param("urgency") String urgency, @Param("jobStartDate") LocalDate jobStartDate,
			@Param("jobEndDate") LocalDate jobEndDate, @Param("plannedStartDate") LocalDate plannedStartDate,
			@Param("plannedEndDate") LocalDate plannedEndDate, @Param("projectId") Integer projectId,
			@Param("createdBy") Integer createdBy, @Param("createdDate") LocalDate createdDate);

	@Query(value = "{CALL maha_closed_report(:taskId,:description,:wiw,:statusId,:team,:priority,:urgency,:closedDateFrom,:closedDateTo,:assingedDateFrom,:assingedDateTo,:projectId)}", nativeQuery = true)
	List<Map<String, String>> closedMahaSearch(@Param("taskId") Integer taskId,
			@Param("description") String description, @Param("wiw") Integer wiw, @Param("statusId") Integer statusId,
			@Param("team") Integer team, @Param("priority") String priority, @Param("urgency") String urgency,
			@Param("closedDateFrom") LocalDate closedDateFrom, @Param("closedDateTo") LocalDate closedDateTo,
			@Param("assingedDateFrom") LocalDate assingedDateFrom, @Param("assingedDateTo") LocalDate assingedDateTo,
			@Param("projectId") Integer projectId);

	@Query(value = "SELECT statusId,NAME FROM tms_admin_status_def", nativeQuery = true)
	List<Map<String, String>> findAllByLists();

}
