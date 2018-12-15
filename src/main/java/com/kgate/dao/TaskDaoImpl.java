package com.kgate.dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.kgate.model.TaskDetails;

@Repository
public class TaskDaoImpl implements TaskDao {
	
	 @Autowired
	 private SessionFactory sessionFactory;


	 @Override
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);
    }


	@SuppressWarnings("unchecked")
	@Override
	public List<TaskDetails> getAllTask() {
		  Session s = this.sessionFactory.getCurrentSession();
		  String query="select task_Type,task_Name,status from task_details";
		return sessionFactory.getCurrentSession().createSQLQuery(query).list();
	}
		
}
	
	
	
	


