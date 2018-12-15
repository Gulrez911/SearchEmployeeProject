package com.kgate.dao;

import java.util.List;

import org.springframework.scheduling.config.Task;

import com.kgate.model.TaskDetails;


public interface TaskDao {
	
	public void addTask(Task task);
	
	 public List<TaskDetails> getAllTask();
	 
	
	

}
