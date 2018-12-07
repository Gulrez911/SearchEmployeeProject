package com.kgate.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.Employee;

public class EmployeeControllerTest {

	/*@Test
	public void testSearchEmployeeBySkill1() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void search() throws IOException {
		EmployeeController ec=new EmployeeController();
		 String skillSearch="HTML";
		 //ModelAndView model=model.setViewName("home");
		 ModelAndView model=new ModelAndView("home");
		//List<Employee> l=ec.searchEmployeeBySkill1(model, skillSearch);
		
		
	}

}
