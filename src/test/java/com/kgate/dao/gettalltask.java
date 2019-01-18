package com.kgate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgate.service.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:appContext.xml"})
public class gettalltask {
	
	@Autowired
	private TaskService taskservice;
	@Test
	public void get()
	{
		taskservice.getalltaskdetails("a@gmail.com");
	}

}
