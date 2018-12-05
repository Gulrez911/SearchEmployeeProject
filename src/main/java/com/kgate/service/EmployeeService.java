package com.kgate.service;

import java.util.List;

import com.kgate.model.Employee;
import com.kgate.model.Skill;

public interface EmployeeService {
	
        //list for search employee
        public List<Employee> searchEmployees(String txt);
        //
        public List<Employee> searchEmployeesBySkill(String skill);
         
    
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);
	  
	public boolean OtpInvalid(String email);
	   
	public boolean Otpvalid(String email);
	public Employee searchByEmail(String email);
}
