package com.kgate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.ProjectDetails;

@Repository
public class ProjectDaoImpl implements ProjectDao
{
	 @Autowired	
	   private SessionFactory sessionFactory;

	@Override
	public void createProject(ProjectDetails project) {
		  Session s = this.sessionFactory.getCurrentSession();
		  s.saveOrUpdate(project);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectDetails> dispalyProjects() {
		Session s = this.sessionFactory.getCurrentSession();
		String Query="select project_Name from Project_Details";
		
		
		return s.createSQLQuery(Query).list();
	}
}
