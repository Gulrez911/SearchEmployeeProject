package com.kgate.service;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.model.Skill;

@Service
@Transactional
public class TaskSeviceImpl implements TaskService {
	

	@Override
	public void addTask(Task task) {
		TaskDao.addTask(task);
		
	}

	
}
