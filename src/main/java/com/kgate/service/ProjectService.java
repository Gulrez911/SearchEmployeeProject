package com.kgate.service;

import java.util.List;

import com.kgate.model.ProjectDetails;

public interface ProjectService 
{
    public void createProject(ProjectDetails project);
    
    List<ProjectDetails> dispalyProjects();
    public int getManagerid(String email);
}
