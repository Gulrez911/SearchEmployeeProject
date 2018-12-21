package com.kgate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDetails;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProject(ProjectDetails project) {
        Session s = this.sessionFactory.getCurrentSession();
        s.saveOrUpdate(project);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProjectDetails> dispalyProjects() {
        return sessionFactory.getCurrentSession().createQuery("from ProjectDetails")
                .list();
    }

	@Override
	public int getManagerid(String email) {
		Query q=sessionFactory.getCurrentSession().createQuery(" select id from  Employee where email='"+email+"'");
		
		
		
	/*	 int id=Integer.parseInt(s);
		 return id;*/
		int id=(int)q.uniqueResult();
		return id;
		
	}

	@Override
	public List<TaskDetails> displayAllProjectTaskDetails() {
		/* Session s = this.sessionFactory.getCurrentSession();
		 s.createQuery("from");*/
		return null;
	}
}
