package com.kgate.dao;

import java.util.List;

import com.kgate.model.ProjectDetails;
import com.kgate.model.ProjectReportDTO;

import com.kgate.model.TaskDTO;

public interface ProjectDao {

    public void createProject(ProjectDetails project);

    List<ProjectDetails> dispalyProjects();

    public int getManagerid(String email);

    //return projectName for CEO
//          public List<String> getProjectName();
    List<ProjectDetails> getProjectByEmail(String email);

    //List project details and Status
    public List<TaskDTO> displayAllStatus(int id);

    //ListProject Report Details DTO
    public List<ProjectReportDTO> listProjectReport();
}
