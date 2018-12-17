package com.kgate.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.TaskDetails;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTask(TaskDetails task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TaskDetails> getAllTask() {
        return sessionFactory.getCurrentSession().createQuery("from TaskDetails")
                .list();
    }

    //return employee name from manager email
    @Override
    public List<String> getEmployeeEmail(String email) {

        String query = "select email from employee123 where category='employee' and managerid = (select id from employee123 where category = 'manager' and email=" + email + ")";

        String query2 = "select email from employee123 where category='employee' and managerid = (select id from employee123 where category = 'manager' and email='surkhab@gmail.com')";
//        String query = "select distinct(s.skill_name) from Skills s cross join join_employee_skill je,employee123 e1   where s.skill_id=je.skill_id and je.id= '" + email + "'";
//        String query2= "from Employee  where category = 'employee' and managerId = (select id from Employee where category = 'manager' and email ="+email+") ";
        return sessionFactory.getCurrentSession().createSQLQuery(query2).list();
//          return sessionFactory.getCurrentSession().createQuery(query2).list();
    }

}
