package com.kgate.service;

<<<<<<< HEAD
import java.sql.Date;
import java.util.List;

import com.kgate.model.TaskDetails;

public interface TaskService {
=======
import java.util.List;
>>>>>>> branch 'master' of https://Gulrez911@github.com/Gulrez911/SearchEmployeeProject.git

<<<<<<< HEAD
	public List<TaskDetails> getalltaskdetails(String email);

	public void updateTask(TaskDetails taskDetails);
	
	public void updatetask1(Date date,String email,int tid,String st);
	
	 public TaskDetails getEmployeeTask(int taskid);
=======
import org.springframework.scheduling.config.Task;

import com.kgate.model.TaskDetails;

public interface TaskService {

	
	public void addTask(TaskDetails task);
	
	public List<TaskDetails> getAllTask();
	public List<TaskDetails> getByProjectId(int id);
	 


    //return employee name from manager email
    public List<String> getEmployeeEmail(String email);
    //return task 
     public TaskDetails getTask(int task_id);
>>>>>>> branch 'master' of https://Gulrez911@github.com/Gulrez911/SearchEmployeeProject.git
}
