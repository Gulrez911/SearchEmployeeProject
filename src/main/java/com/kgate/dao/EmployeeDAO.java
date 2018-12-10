package com.kgate.dao;

import java.util.List;
import com.kgate.model.Employee;
import com.kgate.model.Skill;

public interface EmployeeDAO {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();
    //search Employee

    public List<Employee> searchEmployees(String txt);

    public Employee searchByEmail(String email);

    public void deleteEmployee(Integer employeeId);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployee(int employeeid);

    public List<Employee> searchEmployeesBySkill(String skill);

    public List<Employee> displayByManagerId(String email);

}
