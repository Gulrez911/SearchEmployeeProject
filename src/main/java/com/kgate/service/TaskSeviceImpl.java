package com.kgate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kgate.dao.TaskDao;
import com.kgate.model.TaskDetails;
import java.util.ArrayList;

@Service
@Transactional
public class TaskSeviceImpl implements TaskService {

    @Autowired
    private TaskDao taskdao;

    @Override
    public void addTask(TaskDetails task) {
        taskdao.addTask(task);

    }


	@Override
	public List<TaskDetails> getByProjectId(int id) {
		
		return taskdao.getByProjectId(id);
	}
		
		

    @Override
    public List<TaskDetails> getAllTask() {
        return taskdao.getAllTask();
    }

    //return employee name from manager email
    @Override
    @Transactional
    public List<String> getEmployeeEmail(String email) {
        List<String> li = new ArrayList<String>();
        li = taskdao.getEmployeeEmail(email);
        System.out.println("List of EmployeeEMail:::::::::::"+li);
        return li;
    }

    @Override
    public TaskDetails getTask(int task_id) {

        return  taskdao.getTask(task_id);
    }


}
