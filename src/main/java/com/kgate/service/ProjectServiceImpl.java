package com.kgate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgate.dao.ProjectDao;
import com.kgate.model.ProjectDetails;

@Service
public class ProjectServiceImpl implements ProjectService
{
  @Autowired
  ProjectDao projectDao;

@Override
@Transactional
public void createProject(ProjectDetails project) 
{
	projectDao.createProject(project);
	
}

@Override
@Transactional
public List<ProjectDetails> dispalyProjects() {
	
	return projectDao.dispalyProjects();
}

@Override
public int getManagerid(String email) {
	return projectDao.getManagerid(email);
}
}