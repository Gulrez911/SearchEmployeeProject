package com.kgate.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kgate.dao.ManagerDao;
import com.kgate.model.Manager;

public class ManagerSeviceImpl implements ManagerService
{
@Autowired
ManagerDao managerdao;
	@Override
	public void addmanager(Manager m) {
		managerdao.addmanager(m);
		
	}

	@Override
	public Manager updateManager(Manager m) {
		
		return managerdao.updateManager(m);
	}

	@Override
	public Manager getManager(int managerId) {
	
		return null;
	}

	@Override
	public void deleteManager(Integer managerId) {
	
		
	}

}
