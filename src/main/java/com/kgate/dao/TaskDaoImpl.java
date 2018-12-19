package com.kgate.dao;

<<<<<<< HEAD
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
=======
import java.util.List;

import javax.mail.Session;

>>>>>>> branch 'master' of https://Gulrez911@github.com/Gulrez911/SearchEmployeeProject.git
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.kgate.model.TaskDetails;
=======
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

        return sessionFactory.getCurrentSession().createQuery("from TaskDetails where projectId='" + id + "'")
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
>>>>>>> branch 'master' of https://Gulrez911@github.com/Gulrez911/SearchEmployeeProject.git

@Repository
public class TaskDaoImpl implements TaskDao
{
	 @Autowired
	    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<TaskDetails> getalltaskdetails(String email)
	{
		return sessionFactory.getCurrentSession().createQuery("from TaskDetails where Emp_Email='"+email+"'").list();
	}

	@Override
	public void updateTask(TaskDetails taskDetails) {
		 
		 sessionFactory.getCurrentSession().saveOrUpdate(taskDetails);
	}

	@Override
	public void updatetask1(Date date,String email,int tid,String st) {
		Query query=sessionFactory.getCurrentSession().createQuery("update TaskDetails set tSub_Date='"+date+"',status='"+st+"' where Emp_Email='"+email+"' and task_id='"+tid+"'");
		query.executeUpdate();
		
	}

	@Override
	public TaskDetails getEmployeeTask(int taskid) {
		return(TaskDetails)sessionFactory.getCurrentSession().get(TaskDetails.class, taskid);
	}
	
				
}
