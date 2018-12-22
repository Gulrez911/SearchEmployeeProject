package com.kgate.service;

import java.sql.Date;
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
    @Transactional
    public List<String> getalltaskdetails(String email) {
        List<String> li = new ArrayList<String>();
        li = taskdao.getalltaskdetails(email);
        System.out.println("List of Employee Task::::     " + li);

        return li;
    }

    @Override
    @Transactional
    public void updateTask(TaskDetails taskDetails) {
        taskdao.updateTask(taskDetails);

    }

    @Override
    @Transactional
    public void updatetask1(Date date, String email, int tid, String st) {
        taskdao.updatetask1(date, email, tid, st);

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

}
