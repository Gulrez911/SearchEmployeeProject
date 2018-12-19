package com.kgate.controller;

import java.util.List;
import java.io.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.Employee;
import com.kgate.model.TaskDetails;
import com.kgate.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskservice;

	@RequestMapping(value = "/editTask", method = RequestMethod.POST)
	public ModelAndView updateTask(@ModelAttribute("taskdetails") TaskDetails taskdetails,
			 HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("EmployeeDashboard1");
		String st = taskdetails.getStatus();
	String st1 = st.split(",")[0];

//		mav.addObject("taskdetails",taskdetails);
	/*	List<TaskDetails> tlist = taskservice.getalltaskdetails(employee.getEmail());*/
	List<TaskDetails> tlist = taskservice.getalltaskdetails(taskdetails.getEmp_Email());
		String[] taskStatus = { "W.I.P.", "complete" };
		mav.addObject("taskStatus", taskStatus);
		mav.addObject("tlist", tlist);
		/*mav.addObject(employee);*/
		Employee employee=new Employee();
		employee.setEmail(taskdetails.getEmp_Email());
		mav.addObject(employee);
		long millis = System.currentTimeMillis();
		java.sql.Date date1 = new java.sql.Date(millis);
		/* int tid1=Integer.parseInt(tid); */
		/*
		 * Cookie ck[]=request.getCookies(); String tid2=ck[0].getValue(); int
		 * tid3=Integer.parseInt(tid2);
		 */
		/*String s = request.getParameter("tid");
		int tid3 = Integer.parseInt(s);*/
		taskservice.updatetask1(date1, taskdetails.getEmp_Email(), taskdetails.getTask_id(), st1);
		return mav;
		
	}

	/*@RequestMapping(value = "/editlink", method = RequestMethod.GET)
	public ModelAndView updateTask1(@ModelAttribute("taskdetails") TaskDetails taskdetails,
			@ModelAttribute("employee") Employee employee, @RequestParam("tid") int tid, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("EmployeeDashboard1");

		
		 * String st=taskdetails.getStatus(); String st1=st.split(",")[0];
		 
		String st1 = "complete";
		String mail = request.getParameter("mail");
//		mav.addObject("taskdetails",taskdetails);
		List<TaskDetails> tlist = taskservice.getalltaskdetails(mail);
		String[] taskStatus = { "W.I.P.", "complete" };
		mav.addObject("taskStatus", taskStatus);
		mav.addObject("tlist", tlist);

		 mav.addObject(employee); 
		Employee emp = new Employee();
		emp.setEmail(mail);
		mav.addObject("employee", emp);
		long millis = System.currentTimeMillis();
		java.sql.Date date1 = new java.sql.Date(millis);
		 int tid1=Integer.parseInt(tid); 
		
		 * Cookie ck[]=request.getCookies(); String tid2=ck[0].getValue(); int
		 * tid3=Integer.parseInt(tid2);
		 
		String s = request.getParameter("tid");
		int tid3 = Integer.parseInt(s);
		taskservice.updatetask1(date1, mail, tid3, st1);
		return mav;
		 return new ModelAndView("redirect:/EmployeeDashboard"); 
	}
*/
	@RequestMapping(value = "/editlink1", method = RequestMethod.GET)
	public ModelAndView updateTask2(@ModelAttribute("taskdetails") TaskDetails taskdetails,
			@ModelAttribute("employee") Employee employee, @RequestParam("tid") int tid, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("EmployeTaskEdit");
		String mail = request.getParameter("mail");
		List<TaskDetails> tlist = taskservice.getalltaskdetails(mail);
		mav.addObject("tlist", tlist);
		int tid1 = Integer.parseInt(request.getParameter("tid"));
		taskdetails = taskservice.getEmployeeTask(tid1);
		mav.addObject("taskdetails", taskdetails);
		String[] taskStatus = { "W.I.P.", "complete" };
		mav.addObject("taskStatus", taskStatus);
		return mav;

	}
}
