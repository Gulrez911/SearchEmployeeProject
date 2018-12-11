package com.kgate.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgate.model.Employee;
import com.kgate.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:E:\\eclips\\Nikita\\SearchEmployeeProject\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml"})
public class addEmployeeTest 
{
	@Autowired
	EmployeeService employeeservice;
	@Test
	public void test() 
	{
	
	Employee e=null;
//	List<Employee> e=new ArrayList<Employee>();
    String name="rajan singh";
    String telephone="483674567";
     String adhar="786sdcj765789";
    String address= "ndnmcsmcls";
    String category="Employee";
    String email="rajans2206@gmail.com";
    int managerid=2;
     String otp="6543";
     String pan="pkojkl7867";
     String password="rajan123";
     String status="approved";
   
  Employee e1=new Employee(otp, name, email, address, telephone, category, status, password, managerid, adhar, pan);
 
  employeeservice.addEmployee(e1);



}
}
