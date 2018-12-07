package com.kgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgate.dao.EmployeeDAO;
import com.kgate.model.Employee;
import com.kgate.model.Skill;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
//        @Autowired
//        private SkillDao skillDao;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
        //   skillDao.addSkill(skill);
    }
    //Search Employee
    @Override
    @Transactional
    public List<Employee> searchEmployees(String txt) {
        return employeeDAO.searchEmployees(txt);
    }
    //Search Employee
    @Override
    @Transactional
     public List<Employee> searchEmployeesBySkill(String skill){
         return employeeDAO.searchEmployeesBySkill(skill);
     }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    public Employee getEmployee(int empid) {
        return employeeDAO.getEmployee(empid);
    }

    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeDAO.updateEmployee(employee);
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
  
   
	public Employee searchByEmail(String email) {
		
		return employeeDAO.searchByEmail(email);
	}
	@Override
	 @Transactional
	public List<Employee> displayByManagerId(String email) {
		
		return employeeDAO.displayByManagerId(email);
	}
	

    
}
