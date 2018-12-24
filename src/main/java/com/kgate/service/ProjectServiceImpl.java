package com.kgate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgate.dao.ProjectDao;
import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDTO;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Override
    @Transactional
    public void createProject(ProjectDetails project) {
        projectDao.createProject(project);

    }

    @Override
    @Transactional
    public List<ProjectDetails> dispalyProjects() {
        return projectDao.dispalyProjects();
    }

    @Override
    @Transactional
    public int getManagerid(String email) {
        return projectDao.getManagerid(email);
    }

    @Override
    @Transactional
    public List<TaskDTO> displayAllStatus(int id) {
        return projectDao.displayAllStatus(id);
    }

	@Override
	 @Transactional
	public List<ProjectDetails> getProjectByEmail(String email) {
		
		return projectDao.getProjectByEmail(email);
	}
}
