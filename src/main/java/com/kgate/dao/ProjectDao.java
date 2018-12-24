package com.kgate.dao;

import java.util.List;

import com.kgate.model.ProjectDetails;
<<<<<<< HEAD
import com.kgate.model.TaskDetails;
=======
import com.kgate.model.TaskDTO;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

public interface ProjectDao {

    public void createProject(ProjectDetails project);

    List<ProjectDetails> dispalyProjects();

    public int getManagerid(String email);

    //return projectName for CEO
//          public List<String> getProjectName();
<<<<<<< HEAD
	  

	  public List<TaskDetails> displayAllProjectTaskDetails();
	  
	  
	  
	  
	  

=======
    //List project details and Status
    public List<TaskDTO> displayAllStatus(int id);

>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
}
