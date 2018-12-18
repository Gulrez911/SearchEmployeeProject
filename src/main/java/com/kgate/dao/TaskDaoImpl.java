package com.kgate.dao;

import java.util.List;

import javax.mail.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.Skill;
import com.kgate.model.TaskDetails;
import org.springframework.scheduling.config.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTask(TaskDetails task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
    }
    

   /*@Override
    private void deleteTask(TaskDetails task) {
    	Session s = this.sessionFactory.getCurrentSession();
        TaskDetails task = (TaskDetails) s.load(TaskDetails.class, new Integer(task_id));
        if (null != task) {
            this.sessionFactory.getCurrentSession().delete(task);
        }
    }	
    */
    @Override
    public void deleteTask(int task_id) {
        TaskDetails task = (TaskDetails) sessionFactory.getCurrentSession().load(
        		TaskDetails.class, task_id);
        if (null != task) {
            this.sessionFactory.getCurrentSession().delete(task);
        }
    }

        
    

    @SuppressWarnings("unchecked")
    @Override
    public List<TaskDetails> getAllTask() {
        return sessionFactory.getCurrentSession().createQuery("from TaskDetails")
                .list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaskDetails> getByProjectId(int id) {
	
		return sessionFactory.getCurrentSession().createQuery("from TaskDetails where projectId='"+id+"'")
                .list();
		
	}


	

   

    //return employee name from manager email
	@SuppressWarnings("unchecked")
    @Override
    public List<String> getEmployeeEmail(String email) {

        String query2 = "select email from employee123 where category='employee' and managerid = (select id from employee123 where category = 'manager' and email='" + email + "')";
        return sessionFactory.getCurrentSession().createSQLQuery(query2).list();

    }

    @Override
    public TaskDetails getTask(int task_id) {

        return (TaskDetails) sessionFactory.getCurrentSession().get(TaskDetails.class, task_id);
    }







}

