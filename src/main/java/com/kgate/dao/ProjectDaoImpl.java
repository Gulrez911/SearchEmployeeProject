package com.kgate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kgate.model.Project_Details;

public class ProjectDaoImpl implements ProjectDao
{
	 @Autowired	
	   private SessionFactory sessionFactory;

	@Override
	public void createProject(Project_Details project) {
		// TODO Auto-generated method stub
		
	}
}
