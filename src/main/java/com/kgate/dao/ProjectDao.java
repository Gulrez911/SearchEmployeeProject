package com.kgate.dao;

import java.util.List;

import com.kgate.model.ProjectDetails;

public interface ProjectDao 
{
	  public void createProject(ProjectDetails project);
	  
	  List<ProjectDetails> dispalyProjects();
}
