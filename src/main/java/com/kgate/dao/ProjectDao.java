package com.kgate.dao;

import java.util.List;

import com.kgate.model.ProjectDetails;

public interface ProjectDao 
{
	  public void createProject(ProjectDetails project);
	  
	  List<ProjectDetails> dispalyProjects();
	  
	  public int getManagerid(String email);
          
          //return projectName for CEO
//          public List<String> getProjectName();
}
