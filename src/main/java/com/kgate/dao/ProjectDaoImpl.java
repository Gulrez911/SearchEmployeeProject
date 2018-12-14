package com.kgate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kgate.model.ProjectDetails;


public class ProjectDaoImpl implements ProjectDao
{
	 @Autowired	
	   private SessionFactory sessionFactory;

	@Override
	public void createProject(ProjectDetails project) {
		  Session s = this.sessionFactory.getCurrentSession();
		  s.persist(project);
	}
}
