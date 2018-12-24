package com.kgate.service;

import java.util.List;

import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDTO;

public interface ProjectService {

    public void createProject(ProjectDetails project);

    List<ProjectDetails> dispalyProjects();

    public int getManagerid(String email);

    //list of ProjectStatus
    public List<TaskDTO> displayAllStatus(int id);
}
