package com.kgate.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kgate.dao.ProjectDao;
import com.kgate.model.ProjectDetails;


public class ProjectServiceImpl implements ProjectService
{
  @Autowired
  ProjectDao projectDao;

@Override
public void createProject(ProjectDetails project) 
{
	projectDao.createProject(project);
	
}
}