package com.kgate.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl implements TaskDao {
	
	 @Autowired
	 private SessionFactory sessionFactory;


	 @Override
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);
    }
		
}
	
	
	
	


