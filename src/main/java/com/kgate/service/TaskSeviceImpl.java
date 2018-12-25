package com.kgate.service;

import java.util.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.dao.TaskDao;
import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDetails;

@Service
@Transactional
public class TaskSeviceImpl implements TaskService {

	@Autowired
	private TaskDao taskdao;

	@Override
	@Transactional
	public List<String> getalltaskdetails(String email) {
		return taskdao.getalltaskdetails(email);
	}

	@Override
	@Transactional
	public void updateTask(TaskDetails taskDetails) {
		taskdao.updateTask(taskDetails);

	}

	public TaskDetails getEmployeeTask(int taskid) {
		return taskdao.getEmployeeTask(taskid);
	}

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

	// return employee name from manager email
	@Override
	@Transactional
	public List<String> getEmployeeEmail(String email) {
		List<String> li = new ArrayList<String>();
		li = taskdao.getEmployeeEmail(email);
		System.out.println("List of EmployeeEMail:::::::::::" + li);
		return li;
	}

	@Override
	public TaskDetails getTask(int task_id) {

		return taskdao.getTask(task_id);
	}

	@Override
	public List<TaskDetails> getTaskList(int mgrId) {
		return taskdao.getTaskList(mgrId);
	}

	@Override
	public void updatetask1(String date, String email, int tid, String st) {
		taskdao.updatetask1(date, email, tid, st);
	}

	@Override
	public List<ProjectDetails> getempTaskList(String email) {
		List<ProjectDetails> li = new ArrayList<ProjectDetails>();
		li = taskdao.getempTaskList(email);
		 System.out.println("List of Employe:::: task:::::    " +li);
		return li;
	}

}
