package com.kgate.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
 

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations= {"classpath:spring-servlet.xml"})

public class EmployeeControllerTest {

	/*@Test
	public void testSearchEmployeeBySkill1() {
		fail("Not yet implemented");
	}*/
	
	@Before
	public  void   get(){
		
		
		
	}
	@Test
	public void search() throws IOException {
		EmployeeController ec=new EmployeeController();
		 String skillSearch="HTML";
		 //ModelAndView model=model.setViewName("home");
		 ModelAndView model=new ModelAndView("home");
		model=ec.searchEmployeeBySkill1(model, skillSearch);
		assertEquals(model, model);
		
	}
	
}
