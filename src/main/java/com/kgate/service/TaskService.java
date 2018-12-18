package com.kgate.service;

import java.util.List;

import org.springframework.scheduling.config.Task;

import com.kgate.model.TaskDetails;

public interface TaskService {
	
	public void addTask(TaskDetails task);
	
	public List<TaskDetails> getAllTask();
	public List<TaskDetails> getByProjectId(int id);
	 

}
