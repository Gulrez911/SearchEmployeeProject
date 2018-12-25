package com.kgate.dao;

import java.util.Date;
import java.text.DateFormat;
import java.time.LocalDate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDetails;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTask(TaskDetails task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);
	}

	/*
	 * @Override private void deleteTask(TaskDetails task) { Session s =
	 * this.sessionFactory.getCurrentSession(); TaskDetails task = (TaskDetails)
	 * s.load(TaskDetails.class, new Integer(task_id)); if (null != task) {
	 * this.sessionFactory.getCurrentSession().delete(task); } }
	 */
	@Override
	public void deleteTask(int task_id) {
		TaskDetails task = (TaskDetails) sessionFactory.getCurrentSession().load(TaskDetails.class, task_id);
		if (null != task) {
			this.sessionFactory.getCurrentSession().delete(task);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaskDetails> getAllTask() {
		return sessionFactory.getCurrentSession().createQuery("from TaskDetails").list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaskDetails> getByProjectId(int id) {

		return sessionFactory.getCurrentSession().createQuery("from TaskDetails where projectId='" + id + "'").list();

	}

	// return employee name from manager email
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEmployeeEmail(String email) {

		String query2 = "select email from employee123 where category='employee' and managerid = (select id from employee123 where category = 'manager' and email='"
				+ email + "')";
		return sessionFactory.getCurrentSession().createSQLQuery(query2).list();

	}

	@Override
	public TaskDetails getTask(int task_id) {

		return (TaskDetails) sessionFactory.getCurrentSession().get(TaskDetails.class, task_id);
	}

	@SuppressWarnings("unchecked")
	public List<String> getalltaskdetails(String email) {
		return sessionFactory.getCurrentSession().createQuery("from TaskDetails where Emp_Email='" + email + "'")
				.list();
	}

	@Override
	public void updateTask(TaskDetails taskDetails) {

		sessionFactory.getCurrentSession().saveOrUpdate(taskDetails);
	}

	@Override
	public void updatetask1(String date, String email, int tid, String st) {
		Query query = sessionFactory.getCurrentSession().createQuery("update TaskDetails set tSub_Date='" + date
				+ "',taskStatus='" + st + "' where Emp_Email='" + email + "' and task_id='" + tid + "'");
		query.executeUpdate();

	}

	@Override
	public TaskDetails getEmployeeTask(int taskid) {
		return (TaskDetails) sessionFactory.getCurrentSession().get(TaskDetails.class, taskid);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskDetails> getTaskList(int mgrId) {
		return sessionFactory.getCurrentSession().createQuery("from TaskDetails where projectId='" + mgrId + "'")
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectDetails> getempTaskList(String email) {

		String query = "select project_details.project_Name from project_details where project_details.project_id IN (select task_details.projectId from task_details where task_details.Emp_Email='"
				+ email + "')";

		return sessionFactory.getCurrentSession().createSQLQuery(query).list();
	}

}
