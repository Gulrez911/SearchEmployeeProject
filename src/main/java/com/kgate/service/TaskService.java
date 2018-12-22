package com.kgate.service;

import java.sql.Date;
import java.util.List;
import org.springframework.scheduling.config.Task;
import com.kgate.model.TaskDetails;

public interface TaskService {

	public List<String> getalltaskdetails(String email);

	public void updateTask(TaskDetails taskDetails);

	public void updatetask1(Date date, String email, int tid, String st);

	public TaskDetails getEmployeeTask(int taskid);

	public void addTask(TaskDetails task);

	public List<TaskDetails> getAllTask();

	public List<TaskDetails> getByProjectId(int id);

	// return employee name from manager email
	public List<String> getEmployeeEmail(String email);

	// return task
	public TaskDetails getTask(int task_id);

	public List<TaskDetails> getTaskList(int mgrId);

}
