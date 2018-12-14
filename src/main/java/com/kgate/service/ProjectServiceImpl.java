package com.kgate.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kgate.dao.ProjectDao;
import com.kgate.model.Project_Details;

public class ProjectServiceImpl implements ProjectService
{
   @Autowired	
   private SessionFactory sessionFactory;

@Override
public void createProject(Project_Details project) {
	
	
}
}