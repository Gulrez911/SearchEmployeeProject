package com.kgate.controller;

import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kgate.model.Employee;
import com.kgate.model.Holiday;
import com.kgate.model.ProjectDetails;
import com.kgate.model.Skill;
import com.kgate.model.TaskDTO;
import com.kgate.model.TaskDetails;
import com.kgate.service.EmployeeService;
import com.kgate.service.ProjectService;
import com.kgate.service.SkillService;

import com.kgate.service.TaskService;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private TaskService taskservice;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private ProjectService projectservice;

	@Autowired
	private Employee emp;

	public String generateOTP() {
		Random random = new Random();
		String id = String.format("%04d", random.nextInt(10000));
		return id;
	}

	@RequestMapping(value = "/success")
	public ModelAndView success() {
		ModelAndView mav = new ModelAndView("success");
		return mav;
	}

	@RequestMapping(value = "/success1")
	@ResponseBody
	public int success1(HttpServletRequest request) {
		String s = request.getParameter("mail");
		List<TaskDetails> l = taskservice.getalltaskdetails(s);
		int size = l.size();

		return size;
	}

	@RequestMapping(value = "/search_employeelist")
	public ModelAndView searchEmployee(ModelAndView model, @RequestParam("freeText") String freeText)
			throws IOException {
		List<Employee> listEmployee = employeeService.searchEmployees(freeText);
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/search_employeelist_skill1")
	public ModelAndView searchEmployeeBySkill1(ModelAndView model, @RequestParam("skillSearch") String skillSearch)
			throws IOException {
		int flag = 1;
		List<Employee> listEmployee = null;

		List<Skill> listSkill = skillService.getAllSkills();

		for (Skill s : listSkill) {
			String a = s.getSkill_name();
			if (a.contains(skillSearch) || a.equalsIgnoreCase(skillSearch.toLowerCase())
					|| a.equalsIgnoreCase(skillSearch.toUpperCase()) || a.toLowerCase().contains(skillSearch)) {
				listEmployee = employeeService.searchEmployeesBySkill(a);
				model.addObject("listEmployee", listEmployee);
				flag = 0;

			}
		}
		if (flag == 1) {

			model.addObject("error", "Data not found");
			model.setViewName("home");
			return model;

		}
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}

	// with validation
	@RequestMapping(value = "/employeelist")
	public ModelAndView listEmployee(ModelAndView model, ModelMap model1,
			@RequestParam(value = "page", required = false) Integer page) throws IOException {
		int size;

		List<Employee> listEmployee1 = employeeService.getAllEmployees();
		size = listEmployee1.size() / 5;
		Integer startpage = (page - 5 > 0 ? page - 5 : 1);
		Integer endpage = startpage + size + 1;

		List<Employee> listEmployee = employeeService.getAllEmployees(page);
		model.addObject("listEmployee", listEmployee);
		List<Skill> listSkill = skillService.getAllSkills();
		model.addObject("listSkill", listSkill);
		model1.addAttribute("startpage", startpage);
		model1.addAttribute("endpage", endpage);
		model1.addAttribute("page", page);
		model.setViewName("home");
		System.out.println("EmployeeList email:: " + emp.getEmail());
		return model;

	}

	/*
	 * @RequestMapping(value = "/pageemployeelist") public ModelAndView
	 * pagelistEmployee(ModelMap model1,ModelAndView model, @RequestParam(value =
	 * "page", required = false) int page) throws IOException { int size;
	 * List<Employee> listEmployee1= employeeService.getAllEmployees();
	 * size=listEmployee1.size()/5; int startpage = (int) (page - 5 > 0?page - 5:1);
	 * int endpage = startpage + 10;
	 * 
	 * List<Employee> listEmployee = employeeService.getAllEmployees(page);
	 * model.addObject("listEmployee", listEmployee); List<Skill> listSkill =
	 * skillService.getAllSkills(); model.addObject("listSkill", listSkill);
	 * model1.addAttribute("startpage",startpage);
	 * model1.addAttribute("endpage",endpage); model.setViewName("home"); return
	 * model; }
	 */

	/*
	 * @RequestMapping(value = "/pageemployeelist") public ModelAndView
	 * pagelistEmployee(ModelMap model1,ModelAndView model, @RequestParam(value =
	 * "page", required = false) int page) throws IOException { >>>>>>> branch
	 * 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git int size;
	 * List<Employee> listEmployee1= employeeService.getAllEmployees();
	 * size=listEmployee1.size()/5; Long startpage = (page - 5 > 0?page - 5:1); Long
	 * endpage = startpage +size+1;
	 * 
	 * List<Employee> listEmployee = employeeService.getAllEmployees(page);
	 * model.addObject("listEmployee", listEmployee); List<Skill> listSkill =
	 * skillService.getAllSkills(); model.addObject("listSkill", listSkill);
	 * model1.addAttribute("startpage",startpage);
	 * model1.addAttribute("endpage",endpage); model.setViewName("home"); return
	 * model; <<<<<<< HEAD }
	 * 
	 */
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, ModelMap model1,
			@RequestParam(value = "page", required = false) Integer page) {
//        Skill skill = new Skill();
		List<Skill> listSkill = skillService.getAllSkills();
		model.addObject("listSkill", listSkill);
//        model.addObject("skill", skill);

		Employee employee = new Employee();
		model.addObject("employee", employee);

		String[] userType = { "Admin", "Employee", "Manager", "CEO" };
		model.addObject("userTypes", userType);
		model1.addAttribute("page", page);
		model.setViewName("EmployeeForm");

		return model;

	}

	@RequestMapping(value = "/saveEmployee", params = "action1", method = RequestMethod.POST)
	public ModelAndView sendOTPAction(@ModelAttribute("employee") Employee employee, ModelMap model1,
			@RequestParam(value = "page", required = false) Integer page) {

		for (String skill : employee.getSkills()) {
			Skill sk = skillService.getSkillByName(skill);
			employee.getListSkill().add(sk);
		}

		EmployeeController ec = new EmployeeController();

		employee.setStatus("Not Approved");
		employeeService.addEmployee(employee);
//	        System.out.println("otp: " + temp_otp);
		ec.sendMail(employee.getEmail(),
				"Temporary Password=" + employee.getPassword()
						+ "\n click on below mention link use temporary password and" + "\n Reset Your details"
						+ "href=\\\"http://localhost:8080/PMS-1.0\">\"",
				"confirm message");
		ModelAndView model = new ModelAndView();
		List<Skill> listSkill = skillService.getAllSkills();
		model.addObject("listSkill", listSkill);
		model1.addAttribute("page", page);
//	        model.addObject("employee", employee)
		String[] userType = { "Admin", "Employee", "Manager" };
		model.addObject("userTypes", userType);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", params = "action2", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee, ModelAndView model, ModelMap model1,
			@ModelAttribute("page") Integer page) {

		List<Employee> listEmployee = employeeService.getAllEmployees(page);
		model.addObject("listEmployee", listEmployee);
		List<Skill> listSkill = skillService.getAllSkills();
		model.addObject("listSkill", listSkill);
		model1.addAttribute("page", page);
		model.setViewName("redirect:/employeelist");
		/*
		 * if (employee.getOtp().equals(temp_3)) { for (String skill :
		 * employee.getSkills()) { Skill sk = skillService.getSkillByName(skill);
		 * employee.getListSkill().add(sk); } Employee emp =
		 * employeeService.searchByEmail(employee.getEmail()); if (emp == null) { throw
		 * new RuntimeException("cannnot be null"); } else { if
		 * (employee.getOtp().equals(emp.getOtp())) { // emp.setStatus("Approved");
		 * employee.setStatus("Approved"); // employeeService.addEmployee(emp);
		 * employeeService.addEmployee(employee); } else { // send him a message that
		 * otp is invalid return new ModelAndView("invalid"); } } // String
		 * password=employee.getPassword(); EmployeeController ec = new
		 * EmployeeController(); ec.sendMail(employee.getEmail(), "OTP:" +
		 * employee.getOtp() + "\n password:" + employee.getPassword(),
		 * "confirm message"); return new ModelAndView("redirect:/employeelist"); }
		 */
		return model;
	}

	public void sendMail(String to, String message, String subject) {
		final Employee e = new Employee();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gulfarooqui1@gmail.com", "Gulrez#7326");
			}

		});

		Message message1 = new MimeMessage(session);

		try {

			message1.setFrom(new InternetAddress("test@gmail.com"));
			message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message1.setSubject(subject);
			message1.setText(message);

			Transport.send(message1);

			System.out.println("Done");

		} catch (MessagingException e1) {
			throw new RuntimeException(e1);
		}
		// return "employeelist";

	}

	@RequestMapping(value = "/managerpage", method = RequestMethod.GET)
	public ModelAndView taskcreate(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
		String email = request.getParameter("email");
		ModelAndView mav = new ModelAndView("ManagerSuccess");
		employee = new Employee();
		mav.addObject("employee", employee);
		List<Employee> elist = employeeService.displayByManagerId(emp.getEmail());

		mav.addObject("elist", elist);

		String k = request.getParameter("k");
		mav.addObject("k", k);

		return mav;

	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request, ModelMap model1,
			@RequestParam(value = "page", required = false) Integer page, RedirectAttributes redir) {

		int employeeId = Integer.parseInt(request.getParameter("id"));
		/* Long pageId = (long) Integer.parseInt(request.getParameter("page")); */
		employeeService.deleteEmployee(employeeId);
		System.out.println("deleteEmployee:::   " + emp.getEmail());
		model1.addAttribute("page", page);
		redir.addAttribute("page", page);
		ModelAndView mav = new ModelAndView("redirect:/employeelist");
		/* mav.addObject("pageid", pageId); */

		return mav;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request, ModelMap model1,
			@RequestParam(value = "page", required = false) Integer page) {

		int employeeId = Integer.parseInt(request.getParameter("id"));

		List<String> employeeSkill = skillService.getEmployeeSkill(employeeId);
//		System.out.println("List of EmployeeSkill:   " + employeeSkill);
		Employee employee = employeeService.getEmployee(employeeId);
		System.out.println("EditEmployee email   " + emp.getEmail());
		ModelAndView model = new ModelAndView("edit");
		List<Skill> listSkill = skillService.getAllSkills();

		List<String> sk = new ArrayList<>();

		for (int i = 0; i < employeeSkill.size(); i++) {
			Object o = employeeSkill.get(i);
			String s = (String) o;
			sk.add(s);
		}
		employee.setSkills(sk);

		String[] userType = { "Employee", "Admin", "Manager" };
		model.addObject("userTypes", userType);

		model.addObject("listSkill", listSkill);
		model.addObject("employee", employee);

		Skill skill = new Skill();
		model.addObject("skill", skill);

		model1.addAttribute("page", page);
		return model;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public ModelAndView updateperson(@ModelAttribute Employee employee, ModelMap model, HttpServletRequest request,
			@ModelAttribute("page") Integer page) {

		for (String skill : employee.getSkills()) {
			Skill sk = skillService.getSkillByName(skill);
			employee.getListSkill().add(sk);
		}

		employeeService.addEmployee(employee);
		System.out.println("editEmployee List::: " + emp.getEmail());
		String message = "Employee is successfully edited.";
		ModelAndView mav = new ModelAndView("redirect:/employeelist");
		mav.addObject("message", message);

		List<Employee> listEmployee = employeeService.getAllEmployees(page);

		mav.addObject("listEmployee", listEmployee);
		model.addAttribute("page", page);
		return mav;

	}

	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadPDF() {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ModelAndView("pdfView", "listEmployee", listEmployee);
	}

	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ModelAndView("excelView", "listEmployee", listEmployee);
	}

	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public ModelAndView back(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("CreateProject");

		/*
		 * mav.addObject("employee", employee); String[] userType = {"Admin",
		 * "Employee", "Manager","CEO"}; mav.addObject("userTypes", userType);
		 */
		String s = request.getParameter("mail");
		Integer mid = projectservice.getManagerid(emp.getEmail());
		// System.out.println("Manager ID:::: " + mid);
		mav.addObject("mid", mid);
		ProjectDetails projectdetails = new ProjectDetails();
		projectdetails.setManageremail(s);
		TaskDetails taskdetails = new TaskDetails();
		ProjectDetails pd = new ProjectDetails();
		mav.addObject("projectdetails", projectdetails);
		taskdetails.setEmp_Email(employee.getEmail());
		mav.addObject("taskdetails", taskdetails);
		Employee e = new Employee();
		mav.addObject("e", employeeService.searchByEmail(s));
		List<ProjectDetails> listProject = projectservice.getProjectByEmail(emp.getEmail());
		// System.out.println("List of Project: " + listProject);
		mav.addObject("pd", pd);

		mav.addObject("listProject", listProject);
		return mav;

	}

	/*
	 * @RequestMapping(value = "/back", method = RequestMethod.POST)
	 * 
	 * public ModelAndView back(@ModelAttribute("taskdetails") TaskDetails
	 * taskdetails, HttpServletRequest request, @SessionAttribute("employee")
	 * Employee employee) { public ModelAndView back() {
	 * 
	 * int pId = taskdetails.getProjectId(); taskdetails.setProjectId(pId); int mId
	 * = taskdetails.getManagerId(); taskdetails.setManagerId(mId);
	 * taskdetails.setStatus("Not Assigned"); taskservice.addTask(taskdetails);
	 * String[] Tasktype = {"Coding", "Design", "Integration", "Quality",
	 * "Testing"}; mav.addObject("task_Type", Tasktype); List<TaskDetails> listtask
	 * = taskservice.getByProjectId(pId); System.out.println("List of task:  " +
	 * listtask); mav.addObject("td", taskdetails); mav.addObject("listtask",
	 * listtask); Employee e = new Employee();
	 * e.setEmail(taskdetails.getEmp_Email()); mav.addObject("e",
	 * employeeService.searchByEmail(employee.getEmail()));
	 * 
	 * ModelAndView mav = new ModelAndView("CreateProject"); return mav; }
	 */
	@RequestMapping(value = "/byEmployeeEdit", method = RequestMethod.POST)
	public ModelAndView byEmployeeEdit(@ModelAttribute Employee employee) {
		for (String skill : employee.getSkills()) {
			Skill sk = skillService.getSkillByName(skill);
			employee.getListSkill().add(sk);
		}
		employee.setStatus("Approved");
		employeeService.addEmployee(employee);
		String message = "Employee is successfully edited.";
//	        ModelAndView mav = new ModelAndView("EmployeeSuccess");

		ModelAndView mav = new ModelAndView("redirect:/byEmployeeSuccess");
		mav.addObject("message", message);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		mav.addObject("listEmployee", listEmployee);
		EmployeeController ec = new EmployeeController();
		ec.sendMail(employee.getEmail(), "Details are Successfully save", "confirm message");

		return mav;

	}

	@RequestMapping(value = "/byEmployeeSuccess", method = RequestMethod.GET)
	public ModelAndView byEmployeeSuccess(@ModelAttribute Employee employee, ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("byEmployeeEdit");

		Employee emp1 = employeeService.searchByEmail(emp.getEmail());
		List<String> employeeSkill = skillService.getEmployeeSkillByEmail(emp.getEmail());

		System.out.println("List of EmployeeSkill: " + employeeSkill);

		List<Skill> listSkill = skillService.getAllSkills();

		List<String> sk = new ArrayList<>();

		for (int i = 0; i < employeeSkill.size(); i++) {
			Object o = employeeSkill.get(i);
			String s = (String) o;
			sk.add(s);
		}
		emp1.setSkills(sk);
		String[] userType = { "Employee", "Admin", "Manager" };
		mav.addObject("userTypes", userType);

		mav.addObject("listSkill", listSkill);
		mav.addObject("employee", emp1);
		modelMap.addAttribute("msg", "You have successfully edited");
		Skill skill = new Skill();
		mav.addObject("skill", skill);
		return mav;

	}

	@RequestMapping(value = "/byManagerEdit", method = RequestMethod.POST)
	public ModelAndView byManagerEdit(@ModelAttribute Employee employee) {
		for (String skill : employee.getSkills()) {
			Skill sk = skillService.getSkillByName(skill);
			employee.getListSkill().add(sk);
		}
		employee.setStatus("Approved");
		employeeService.addEmployee(employee);
		String message = "Employee is successfully edited.";
//	        ModelAndView mav = new ModelAndView("EmployeeSuccess");

		ModelAndView mav = new ModelAndView("redirect:/bymanagerSuccess");
		mav.addObject("message", message);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		mav.addObject("listEmployee", listEmployee);
		EmployeeController ec = new EmployeeController();
		ec.sendMail(employee.getEmail(), "Details are Successfully save", "confirm message");

		return mav;

	}

	@RequestMapping(value = "/bymanagerSuccess", method = RequestMethod.GET)
	public ModelAndView bymanagerSuccess(@ModelAttribute Employee employee, ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("ManagerEdit");

		Employee emp1 = employeeService.searchByEmail(emp.getEmail());
		List<String> employeeSkill = skillService.getEmployeeSkillByEmail(emp.getEmail());

		System.out.println("List of EmployeeSkill: " + employeeSkill);

		List<Skill> listSkill = skillService.getAllSkills();

		List<String> sk = new ArrayList<>();

		for (int i = 0; i < employeeSkill.size(); i++) {
			Object o = employeeSkill.get(i);
			String s = (String) o;
			sk.add(s);
		}
		emp1.setSkills(sk);
		String[] userType = { "Employee", "Admin", "Manager" };
		mav.addObject("userTypes", userType);

		mav.addObject("listSkill", listSkill);
		mav.addObject("employee", emp1);
		modelMap.addAttribute("msg", "You have successfully edited");
		Skill skill = new Skill();
		mav.addObject("skill", skill);
		return mav;
	}

	@RequestMapping(value = "/backtomanagerDashboard", method = RequestMethod.POST)
	public ModelAndView backtomanagerDash() {
		ModelAndView mav = new ModelAndView("ManagerDashboard");
		mav.addObject("employee", emp);
		return mav;

	}

	@RequestMapping(value = "/employeeReport", method = RequestMethod.GET)
	public ModelAndView employeeReport(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));
		Employee e = employeeService.getEmployee(id);

		String email = request.getParameter("email");
		List<TaskDetails> tls = taskservice.getalltaskdetails(email);
		System.out.println("all list "+tls);

		List<ProjectDetails> pj = projectservice.dispalyProjects();
		
		List<String> lskill=skillService.getEmployeeSkill(id);
		
		List<Holiday> holiday=employeeService.getAllHoliday();

		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		List<TaskDTO> to = new ArrayList<>();
		List<Integer> ii = new ArrayList<>();
		Map<String,Integer> m=new HashMap<String,Integer>();
		
		 Date d12 = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String date1 = sdf.format(d12);
		
		long taskdur1 = 0, taskdur = 0;
		String s = "",d3="",sdd3="";
		int flag = 0,holiday1=0,holi=0;
		long tc1 = 0;

		for (int i = 0; i < tls.size(); i++) {
			TaskDetails ls = tls.get(i);
			Date d1 = ls.gettStart_Time();
			String sd1 = d1.toString();
			Date d2 = ls.gettEnd_Time();
			String sd2 = d2.toString();
			if(ls.gettSub_Date()==null || ls.gettSub_Date()=="" ||ls.gettSub_Date().isEmpty())
			{
				d3=date1;
				
			}else
			{
			 d3 = ls.gettSub_Date();	
			}
			
			String tasknm=ls.getTask_Name();
			try {
				long isd1 = myFormat.parse(sd1).getTime();
				long isd2 = myFormat.parse(sd2).getTime();
				long isd3 =  myFormat.parse(d3).getTime();
				taskdur = isd2 - isd1;
				long tc = isd3 - isd2;
				Integer d=(int)(tc/ (1000 * 60 * 60 * 24));
				System.out.println("map first"+d);
				m.put(tasknm, d);
				tc1 = tc + taskdur;
				for(Holiday h:holiday)
				{
					Date h1=h.gethDays();
					String h2=h1.toString();
					long h12=myFormat.parse(h2).getTime();
					if(h12>isd1 && h12<isd2)
					{
						holiday1=holiday1+1;
					}
				}
				
				System.out.println("first:" + (taskdur / (1000 * 60 * 60 * 24)));
				System.out.println("tadur:" + (tc1 / (1000 * 60 * 60 * 24)));
				System.out.println("holianil:" + (holiday1 / (1000 * 60 * 60 * 24)));
			} catch (Exception e1) {

			}
			

			for (int j = i + 1; j < tls.size(); j++) {
				long ttc1 = 0;
				TaskDetails ls1 = tls.get(j);
				Date dd1 = ls1.gettStart_Time();
				String sdd1 = dd1.toString();
				Date dd2 = ls1.gettEnd_Time();
				String sdd2 = dd2.toString();
				if(ls1.gettSub_Date()==null ||ls1.gettSub_Date()==""||ls1.gettSub_Date().isEmpty())
				{
					sdd3=date1;
				}
				else
				{
					 sdd3 = ls1.gettSub_Date();	
				}
			
				String tasknm1=ls1.getTask_Name();
				try {
					long idd1 = myFormat.parse(sdd1).getTime();
					long idd2 =  myFormat.parse(sdd2).getTime();
					long idd3 =  myFormat.parse(sdd3).getTime();

					taskdur1 = idd2 - idd1;
					long ttc = idd3 - idd2;
					ttc1 = ttc + taskdur1;
					Integer d11=(int)(ttc/ (1000 * 60 * 60 * 24));
					System.out.println("map second"+d11);
					m.put(tasknm1, d11);
					for(Holiday h:holiday)
					{
						Date h1=h.gethDays();
						String h2=h1.toString();
						long h12=myFormat.parse(h2).getTime();
						if(h12>idd1 && h12<idd2)
						{
							holi=holi+1;
						}
					}
					System.out.println("second:" + (taskdur1 / (1000 * 60 * 60 * 24)));
					System.out.println("tadur1:" + (ttc1 / (1000 * 60 * 60 * 24)));
					System.out.println("half:" + (ttc / (1000 * 60 * 60 * 24)));
					System.out.println("holianil1:" + (holi / (1000 * 60 * 60 * 24)));
				} catch (Exception e2) {

				}

				int a = ls.getProjectId();
				int b = ls1.getProjectId();
				if (a == b) {
					taskdur = taskdur + taskdur1;
					tc1 = tc1 + ttc1;
					holiday1=holiday1+holi;
				}

			}

			for (ProjectDetails p : pj) {
				if (p.getProject_id() == ls.getProjectId()) {
					s = p.getProject_Name();
				}
			}

			float totaldur1 = (taskdur / (1000 * 60 * 60 * 24));
			int totalduur1 = (int) totaldur1;
			System.out.println("toalana:" + totalduur1);
			int ttotalduur1=totalduur1-holiday1;
			String totaldur2 = Integer.toString(totalduur1);
			
			System.out.println("String totalDur:::: " + totaldur2);
			float totalc1 = (tc1 / (1000 * 60 * 60 * 24));
			int totalcc1 = (int) totalc1;
			String totalc2 = Integer.toString(totalcc1);
			System.out.println("comanil: " + totalc2);
			
			int devi=totalcc1-totalduur1;
			String deviation=Integer.toString(devi);
			
			for (int p : ii) {
				if (p == ls.getProjectId()) {
					flag = 1;
				}
			}
			if (flag == 0) {
				ii.add(ls.getProjectId());

				TaskDTO t = new TaskDTO();
				t.setEstimateDays(totaldur2);
				t.setProject_Name(s);
				t.setActualDays(totalc2);
				t.setDelayDays(deviation);
				to.add(t);
				taskdur = 0;
				tc1 = 0;
				holi=0;
			}
			holiday1=0;
			holi=0;
		}
		
		
		/* return new ModelAndView("pdfemployeeReport", "e", e); */
		ModelAndView mav = new ModelAndView("pdfemployeeReport");
		mav.addObject("e", e);
		mav.addObject("tdo", to);
		mav.addObject("lskill",lskill);
		
	Set<Entry<String,Integer>> set=m.entrySet();
	List<Entry<String,Integer>> list=new ArrayList<Entry<String,Integer>>(set);
	Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			
			 return (o2.getValue()).compareTo( o1.getValue() );
		}
		
		
	});
	 for(Map.Entry<String, Integer> entry:list){
         System.out.println("sorted "+entry.getKey()+" ==== "+entry.getValue());
         
	 }
	 mav.addObject("list",list);
		return mav;

	}
	

}