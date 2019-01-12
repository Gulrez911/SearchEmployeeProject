package com.kgate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.Employee;


import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        //  sessionFactory.getCurrentSession().saveOrUpdate(skill);
        logger.info("Details of employee is successfully save");
    }

    @SuppressWarnings("unchecked")
    public List<Employee> searchEmployeesBySkill(String txt) {

        String qry = "select employee0_.name, employee0_.email, employee0_.address, employee0_.telephone, employee0_.category  from  Employee_Details employee0_ cross  join join_employee_skill listskill1_, Skills skill2_  where  employee0_.id=listskill1_.id and listskill1_.skill_Id=skill2_.skill_Id  and skill2_.skill_name LIKE '" + txt + "'";
        List<Object> data = sessionFactory.getCurrentSession().createSQLQuery(qry).list();
        List<Employee> emp = new ArrayList<>();
//      Employee e = new Employee();

        for (Object d : data) {

            Object arr[] = (Object[]) d;
            String st, st1, st2, st3, st4;
//          String s[] = null;
//          for (int i = 0; i <= arr.length; i++) {
//              s[i] = (String) arr[i];
//
//          }
            Employee e = new Employee();
            st = (String) arr[0];
            st1 = (String) arr[1];
            st2 = (String) arr[2];
            st3 = (String) arr[3];
            st4 = (String) arr[4];

            e.setName(st);
            e.setEmail(st1);
            e.setAddress(st2);
            e.setTelephone(st3);
            e.setCategory(st4);
            emp.add(e);

        }
        logger.info("employee search by skill is successfully," +emp);
        return emp;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> searchEmployees(String txt) {

        String query = "from Employee u where u.name like '" + txt + "%' or u.email like '" + txt + "%' or u.address like '" + txt + "%' or u.telephone like '" + txt + "%' ";
        logger.info("Details loaded successfully, employee details=" +query);

        return sessionFactory.getCurrentSession().createQuery(query).list();
        
       
        
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {

    return  sessionFactory.getCurrentSession().createQuery("from Employee")
    	         .list();
    }
    

    @Override
    public void deleteEmployee(Integer employeeId) {

        String query = "delete Employee_Details, join_employee_skill from Employee_Details inner join  join_employee_skill  where  Employee_Details.id = join_employee_skill.id and Employee_Details.id =" + employeeId + "";
        if(query !=null)
        {
        SQLQuery sqlq = sessionFactory.getCurrentSession().createSQLQuery(query);
        sqlq.executeUpdate();
        } else {
            logger.info("employee details are not present");
        }
        logger.info("details of employee are deleted succesfully");
    }

    public Employee getEmployee(int empid) {
    	  Session s = this.sessionFactory.getCurrentSession();
    	  Employee e=(Employee) s.get(Employee.class,empid);
    	  logger.info("Details loaded successfully, employee details=" +e);

        return e;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        logger.info("Details are updated");
        return employee;
    }

    @Override
    public Employee searchByEmail(String email) {
        String query = "from Employee u where u.email = '" + email + "'";
        List<Object> emps = sessionFactory.getCurrentSession().createQuery(query).list();
        if (emps != null && emps.size() > 0) {
            Employee employee = (Employee) emps.get(0);
            logger.info("employee search by email succesfully");
            return employee;
        }
        return null;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> displayByManagerId(String email) {

        String query = "select  name,address,telephone,email,status,managerId,password,category from Employee_Details where managerId=(select id from Employee_Details where email='" + email + "') ";
//       String query = "select  name,address,telephone,email,status,managerId,otp,password,category from Employee_Details   where category='Employee' and managerId=(select ManagerId from Employee_Details where category='Manager' and email='"+email+"')";
        //        String query = "select  name,address,telephone,email,status,managerId,otp,password,category from Employee_Details where managerId=(select id from Employee_Details where email='" + email + "') ";

        List<Object> data = sessionFactory.getCurrentSession().createSQLQuery(query).list();
        List<Employee> emp = new ArrayList<>();
        for (Object d : data) {

            Object arr[] = (Object[]) d;
            String st, st1, st2, st3, st4;

            Employee e = new Employee();
            st = (String) arr[0];
            st1 = (String) arr[1];
            st2 = (String) arr[2];
            st3 = (String) arr[3];
            st4 = (String) arr[4];

            e.setName(st);
            e.setAddress(st1);
            e.setTelephone(st2);
            e.setEmail(st3);
            e.setCategory(st4);
            emp.add(e);
        }
        logger.info("display employee by manager id"+emp);
        return emp;
    }

	@Override
	public String getEmployeeName(String email) {
		
		 String query1 = "select name from employee_details where email='" + email + "'";
	        Query query2 = sessionFactory.getCurrentSession().createSQLQuery(query1);
	        String name1 = (String) query2.uniqueResult();
	        
	        logger.info("display employee Name By email"+name1);
	        return name1;
		
	}

	private static final int limitResultsPerPage = 5;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(Integer page) {
		page=page-1;
		 Query q=sessionFactory.getCurrentSession().createQuery("from Employee");
		  q.setFirstResult((int) (page * limitResultsPerPage));
		  q.setFetchSize(limitResultsPerPage);
	        q.setMaxResults(limitResultsPerPage);
	        return (List<Employee>) q.list();
	
		
		 
	                
		
	}

}