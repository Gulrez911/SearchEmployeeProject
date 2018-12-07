package com.kgate.service;

import com.kgate.model.Manager;

public interface ManagerService 
{
	public void addmanager(Manager m);
	  public Manager updateManager(Manager m);

	    public Manager getManager(int managerId);
	    public void deleteManager(Integer managerId);

}
