package com.kgate.service;

import java.util.List;

import org.springframework.scheduling.config.Task;

import com.kgate.model.TaskDetails;

public interface TaskService {
	
	public void addTask(Task task);
	
	public List<TaskDetails> getAllTask();
	 

}
