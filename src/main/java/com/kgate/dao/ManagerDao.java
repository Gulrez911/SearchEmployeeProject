package com.kgate.dao;


import com.kgate.model.Manager;

public interface ManagerDao 
{
	public void addmanager(Manager m);
	  public Manager updateManager(Manager m);

	    public Manager getManager(int managerId);
	    public void deleteEmployee(Integer managerId);

}
