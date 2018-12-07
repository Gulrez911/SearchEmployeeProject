package com.kgate.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kgate.model.User;

@Repository("LoginDao2")
public class LoginDao2Impl implements LoginDao2  {
	@Autowired
	private SessionFactory sessionFactory;
	
	 public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}

	 protected Session getSession()
	 	{
	     return sessionFactory.openSession();
	 	}

	  public boolean checkLogin(String userName,String userPassword) 
	  	{
		  Session session = sessionFactory.openSession();
		  boolean userFound = false;
		  String SQL_QUERY ="from Employee where email=? and password=?";
		  Query query = session.createQuery(SQL_QUERY);
		  query.setParameter(0,userName);
		  query.setParameter(1,userPassword);
		  List list = query.list();
		
		if ((list != null) && (list.size() > 0))
		{
			userFound= true;
		}

		session.close();
		return userFound;              

	  	}

	

}
