package com.kgate.dao;

import java.util.List;

import org.springframework.scheduling.config.Task;

import com.kgate.model.TaskDetails;

public interface TaskDao {

	
	public void addTask(TaskDetails task);
	public List<TaskDetails> getByProjectId(int id);

    public List<TaskDetails> getAllTask();

    //return employee name from manager email
    public List<String> getEmployeeEmail(String email);
    //return task 
     public TaskDetails getTask(int task_id);
}
