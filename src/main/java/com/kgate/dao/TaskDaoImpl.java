package com.kgate.dao;

import com.kgate.model.Employee;
import com.kgate.model.TaskDTO;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.TaskDetails;
import java.util.ArrayList;

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
    public List<TaskDetails> getalltaskdetails(String email) {
        return sessionFactory.getCurrentSession().createQuery("from TaskDetails where Emp_Email='" + email + "'")
                .list();
    }

    @Override
    public void updateTask(TaskDetails taskDetails) {

        sessionFactory.getCurrentSession().saveOrUpdate(taskDetails);
    }

    @Override
    public void updatetask1(Date date, String email, int tid, String st) {
        Query query = sessionFactory.getCurrentSession().createQuery("update TaskDetails set tSub_Date='" + date
                + "',status='" + st + "' where Emp_Email='" + email + "' and task_id='" + tid + "'");
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
    public List<TaskDTO> getEmpTasklist(String email) {
        String query = "select project_details.project_Name, task_details.task_Type, task_details.task_Name, task_details.tStart_Time, task_details.tEnd_Time,employee123.name, task_details.status, task_details.task_id, task_details.Emp_Email  from task_details cross join employee123, project_details where task_details.projectId = project_details.project_id and task_details.managerId=employee123.id and task_details.Emp_Email ='" + email + "'";
        List<Object> data = sessionFactory.getCurrentSession().createSQLQuery(query).list();
        System.out.println("List of Object::::   " + data);

        List<TaskDTO> listdto = new ArrayList<TaskDTO>();
        List<Object> testObj = new ArrayList<Object>();
        for (Object d : data) {

            Object arr[] = (Object[]) d;
            String st, st1, st2, st3, st4, st5, st6, st8;
            int i;

            TaskDTO tdto = new TaskDTO();

            st = (String) arr[0];
            st1 = (String) arr[1];
            st2 = (String) arr[2];
            st5 = (String) arr[5];
            st3 = (String) arr[3].toString();
            st4 = (String) arr[4].toString();
            st6 = (String) arr[6];
            i = (int) arr[7];
            st8 = (String) arr[8];

            tdto.setProject_Name(st);
            tdto.setTask_Type(st1);
            tdto.setTask_Name(st2);
            tdto.settStartDate(st3);
            tdto.settEndDate(st4);
            tdto.setName(st5);
            tdto.setStatus(st6);
            tdto.setId(i);
            tdto.setEmail(st8);

            listdto.add(tdto);
            System.out.println("List of Name::::   " + tdto);
            System.out.println("List of Object::::   " + listdto);

        }
        return listdto;
    }
}
