package com.kgate.dao;

import com.kgate.model.ProjectDTO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.ProjectDetails;
<<<<<<< HEAD
import com.kgate.model.TaskDetails;
=======
import com.kgate.model.TaskDTO;
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

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
        Query q = sessionFactory.getCurrentSession().createQuery(" select id from  Employee where email='" + email + "'");

        /*	 int id=Integer.parseInt(s);
		 return id;*/
<<<<<<< HEAD
		int id=(int)q.uniqueResult();
		return id;
		
	}

	@Override
	public List<TaskDetails> displayAllProjectTaskDetails() {
		/* Session s = this.sessionFactory.getCurrentSession();
		 s.createQuery("from");*/
		return null;
	}
=======
        int id = (int) q.uniqueResult();
        return id;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TaskDTO> displayAllStatus(int id) {

        String query = "select a.name AS 'Employee Name' ,b.name AS 'Manager Name', task_details.task_Name, task_details.task_Type,task_details.tStart_Time,task_details.tEnd_Time, task_details.status from employee123 a, employee123 b cross join task_details where a.category = 'employee' AND a.managerId = b.id AND b.category ='Manager' AND task_details.Emp_Email=a.email AND task_details.projectId='"+id+"'";

        List<TaskDTO> listtsk = new ArrayList<TaskDTO>();
        List<Object> data = sessionFactory.getCurrentSession().createSQLQuery(query).list();

        for (Object d : data) {

            Object arr[] = (Object[]) d;
            String st, st1, st2, st3, st4, st5, st6, st8;

            TaskDTO tdto = new TaskDTO();

            st = (String) arr[0];
            st1 = (String) arr[1];
            st2 = (String) arr[2];
            st3 = (String) arr[3];
            st4 = arr[4].toString();
            st5 = arr[5].toString();
            st6 = (String) arr[6];
            
            tdto.setEmp_name(st);
            tdto.setName(st1);
            tdto.setTask_Name(st2);
            tdto.setTask_Type(st3);
            tdto.settStartDate(st4);
            tdto.settEndDate(st5);
            tdto.setStatus(st6);
            
            listtsk.add(tdto);
        }
 
        return listtsk;
    }
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
}
