package com.kgate.dao;

<<<<<<< HEAD
import java.sql.Date;
import java.util.List;

import com.kgate.model.Employee;
=======
import java.util.List;

import org.springframework.scheduling.config.Task;

>>>>>>> branch 'master' of https://Gulrez911@github.com/Gulrez911/SearchEmployeeProject.git
import com.kgate.model.TaskDetails;

public interface TaskDao {

<<<<<<< HEAD
	public List<TaskDetails> getalltaskdetails(String email);

	public void updateTask(TaskDetails taskDetails);

	 public void updatetask1(Date date,String email,int tid,String st);
	 
	 public TaskDetails getEmployeeTask(int taskid);
=======
    
    public void deleteTask(int task_id );


	
	public void addTask(TaskDetails task);
	public List<TaskDetails> getByProjectId(int id);


    public List<TaskDetails> getAllTask();

    //return employee name from manager email
    public List<String> getEmployeeEmail(String email);
    //return task 
     public TaskDetails getTask(int task_id);

	
>>>>>>> branch 'master' of https://Gulrez911@github.com/Gulrez911/SearchEmployeeProject.git
}
