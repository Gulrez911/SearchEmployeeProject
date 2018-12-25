package com.kgate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.kgate.model.Employee;
import com.kgate.model.TaskDetails;
import com.kgate.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskservice;
	
    @InitBinder
    public void initConverter(WebDataBinder binder) {
        CustomDateEditor dateEditor = new CustomDateEditor(new ISO8601DateFormat(), true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

	@RequestMapping(value = "/editTask", method = RequestMethod.POST)
	public ModelAndView updateTask(@ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("EmployeeDashboard1");
		String st = taskdetails.getStatus();
		String st1 = st.split(",")[0];

//		mav.addObject("taskdetails",taskdetails);
		/*
		 * List<TaskDetails> tlist = taskservice.getalltaskdetails(employee.getEmail());
		 */
		List<String> tlist = taskservice.getalltaskdetails(taskdetails.getEmp_Email());
		String[] taskStatus = { "W.I.P.", "complete" };
		mav.addObject("taskStatus", taskStatus);
		mav.addObject("tlist", tlist);
		/* mav.addObject(employee); */
		Employee employee = new Employee();
		employee.setEmail(taskdetails.getEmp_Email());
		mav.addObject(employee);
		/*long millis = System.currentTimeMillis(); 
		java.util.Date date1 = new java.util.Date(millis);
		System.out.println(date1);*/
		/*
		 * DateFormat date1 = new SimpleDateFormat("dd-MM-yyyy"); Date date = new
		 * Date(); date1.format(date);
		 */
		/*LocalDate d = java.time.LocalDate.now();*/
		/* int tid1=Integer.parseInt(tid); */
		/*
		 * Cookie ck[]=request.getCookies(); String tid2=ck[0].getValue(); int
		 * tid3=Integer.parseInt(tid2);
		 */
		/*
		 * String s = request.getParameter("tid"); int tid3 = Integer.parseInt(s);
		 */
		Date d1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date1=sdf.format(d1);
		
	taskservice.updatetask1(date1, taskdetails.getEmp_Email(), taskdetails.getTask_id(), st1);
		return mav;

	}

	/*
	 * @RequestMapping(value = "/editlink", method = RequestMethod.GET) public
	 * ModelAndView updateTask1(@ModelAttribute("taskdetails") TaskDetails
	 * taskdetails,
	 * 
	 * @ModelAttribute("employee") Employee employee, @RequestParam("tid") int tid,
	 * HttpServletRequest request) {
	 * 
	 * ModelAndView mav = new ModelAndView("EmployeeDashboard1");
	 * 
	 * 
	 * String st=taskdetails.getStatus(); String st1=st.split(",")[0];
	 * 
	 * String st1 = "complete"; String mail = request.getParameter("mail"); //
	 * mav.addObject("taskdetails",taskdetails); List<TaskDetails> tlist =
	 * taskservice.getalltaskdetails(mail); String[] taskStatus = { "W.I.P.",
	 * "complete" }; mav.addObject("taskStatus", taskStatus); mav.addObject("tlist",
	 * tlist);
	 * 
	 * mav.addObject(employee); Employee emp = new Employee(); emp.setEmail(mail);
	 * mav.addObject("employee", emp); long millis = System.currentTimeMillis();
	 * java.sql.Date date1 = new java.sql.Date(millis); int
	 * tid1=Integer.parseInt(tid);
	 * 
	 * Cookie ck[]=request.getCookies(); String tid2=ck[0].getValue(); int
	 * tid3=Integer.parseInt(tid2);
	 * 
	 * String s = request.getParameter("tid"); int tid3 = Integer.parseInt(s);
	 * taskservice.updatetask1(date1, mail, tid3, st1); return mav; return new
	 * ModelAndView("redirect:/EmployeeDashboard"); }
	 */
	@RequestMapping(value = "/editlink1", method = RequestMethod.GET)
	public ModelAndView updateTask2(@ModelAttribute("taskdetails") TaskDetails taskdetails,
			@ModelAttribute("employee") Employee employee, @RequestParam("tid") int tid, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("EmployeTaskEdit");
		String mail = request.getParameter("mail");
		List<String> tlist = taskservice.getalltaskdetails(mail);
		mav.addObject("tlist", tlist);
		int tid1 = Integer.parseInt(request.getParameter("tid"));
		taskdetails = taskservice.getEmployeeTask(tid1);
		mav.addObject("taskdetails", taskdetails);
		String[] taskStatus = { "W.I.P.", "complete" };
		mav.addObject("taskStatus", taskStatus);
		return mav;

	}
}
