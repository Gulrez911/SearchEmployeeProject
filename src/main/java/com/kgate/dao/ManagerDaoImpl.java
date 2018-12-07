package com.kgate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.Employee;
import com.kgate.model.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao
{

	  @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public void addmanager(Manager m) {
		 sessionFactory.getCurrentSession().saveOrUpdate(m);
		
	}

	@Override
	public Manager updateManager(Manager m) {
		 sessionFactory.getCurrentSession().update(m);
		return m;
	
	}

	@Override
	public Manager getManager(int managerId) {
	
		return (Manager) sessionFactory.getCurrentSession().get(
                Employee.class,
                managerId);
	}

	@Override
	public void deleteEmployee(Integer managerId) {
		  Session s = this.sessionFactory.getCurrentSession();
	        Manager m = (Manager) s.load(Manager.class, new Integer(managerId));
	        if (m != null) {
	            s.delete(m);
	        } 
	        
		
	}

}
