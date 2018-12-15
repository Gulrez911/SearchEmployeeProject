package com.kgate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgate.model.Employee;
import com.kgate.model.ProjectDetails;
import com.kgate.model.Skill;
import com.kgate.model.TaskDetails;
import com.kgate.model.User;

import com.kgate.service.EmployeeService;
import com.kgate.service.LoginService2;
import com.kgate.service.ProjectService;
import com.kgate.service.SkillService;
import com.kgate.service.TaskService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.config.Task;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

@Controller
// @RequestMapping(value = ("/"))
public class UserController {

	@Autowired
	private LoginService2 loginservice2;

	@Autowired
	private SkillService skillService;


    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ProjectService projectservice;
    
    @Autowired
    private TaskService taskservice;


	
	public void setloginService1(LoginService2 loginservice2) {
		this.loginservice2 = loginservice2;
	}

	public void setemployeeservice(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView init() {	
		ModelAndView mav = new ModelAndView("login");
	Employee employee = new Employee();
	mav.addObject("employee", employee);
	String[] userType = { "Admin", "Employee", "Manager" };
	mav.addObject("userTypes", userType);
	return mav;
}
	
    /*public ModelAndView ct() {
    	ModelAndView mav=new ModelAndView("createtask");
    	TaskDetails TaskDetails=new TaskDetails();
    	mav.addObject("task",TaskDetails);
    	String[] Tasktype= {"Coding","Design","Integration","Quality","Testing"};
    	mav.addObject("task_Type",Tasktype);
    	return mav;*/
    
  /*  @RequestMapping(value=    ,method = RequestMethod.GET)
    public ModelAndView addingtask() {
    	ModelAndView mav=new ModelAndView("createtask");
    	taskservice.addTask();
    	String message ="Task is successfully added";
    	return mav;
    	
    }
    
    */ 
    
    
    
    
    
    

	@RequestMapping(value = "/Edit", method = RequestMethod.POST)
	public ModelAndView editByemployee(@ModelAttribute Employee employee) {
		employeeService.updateEmployee(employee);
		String message = "Employee is successfully edited.";
		// ModelAndView mav = new ModelAndView("EditEmployee");
		ModelAndView mav = new ModelAndView("testfile");
		// mav.addObject("message", message);

		return mav;

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(ModelMap modelMap, @ModelAttribute("employee") Employee employee,
			HttpServletRequest request, Map<String, Object> map, @RequestParam("email") String email) {

		/*
		 * validate whether person is in database and person user and password are
		 * matching
		 */
		boolean isValidUser = loginservice2.checkLogin(employee.getEmail(), employee.getPassword(),
				employee.getCategory());

		if (isValidUser) {
			if (employee.getCategory().equals("Admin")) {

				request.setAttribute("loginuser", employee.getEmail());
				ModelAndView mav = new ModelAndView("success");


                 
                 
                /* ModelAndView mav = new ModelAndView("createtask");
                 TaskDetails taskdetails=new TaskDetails();
                 List<TaskDetails> tdlist=taskservice.getAllTask();
                 mav.addObject("taskdetails",taskdetails);
                
                 String[] task_Type= {"Coding","Design","Integration","Quality","Testing"};
               	mav.addObject("task_Type",task_Type);
               	
               	List<TaskDetails> tdlist=taskservice.getAllTask();
              
               	mav.addObject("tdlist",tdlist);*/
             

				return mav;

			} else if (employee.getCategory().equals("Manager")) {
				ModelAndView mav = new ModelAndView("CreateProject");
				ProjectDetails projectdetails = new ProjectDetails();
				List<ProjectDetails> pdlist = projectservice.dispalyProjects();
				mav.addObject("projectdetails", projectdetails);
				mav.addObject("pdlist", pdlist);

				return mav;

			} else if (employee.getCategory().equals("Employee")) {

				/* Get all data required for Person jsp and set in ModelAndView */
				ModelAndView mav = new ModelAndView("byEmployeeEdit");
				Employee emp = employeeService.searchByEmail(employee.getEmail());
				List<String> employeeSkill = skillService.getEmployeeSkillByEmail(employee.getEmail());

				System.out.println("List of EmployeeSkill:   " + employeeSkill);

				List<Skill> listSkill = skillService.getAllSkills();

				List<String> sk = new ArrayList<>();

				for (int i = 0; i < employeeSkill.size(); i++) {
					Object o = employeeSkill.get(i);
					String s = (String) o;
					sk.add(s);
				}
				emp.setSkills(sk);
				String[] userType = { "Employee", "Admin", "Manager" };
				mav.addObject("userTypes", userType);

				mav.addObject("listSkill", listSkill);
				mav.addObject("employee", emp);

				Skill skill = new Skill();
				mav.addObject("skill", skill);
				return mav;

			} else {
				modelMap.put("error", "Invalid UserName / Password");
				ModelAndView mav = new ModelAndView("login");
				return mav;

			}

		}
		modelMap.put("error", "Invalid UserName / Password");
		return init();
	}

	// Employee Edit by Employee
	@RequestMapping(value = "/byEmployeeEdit", method = RequestMethod.POST)
	public ModelAndView byEmployeeEdit(@ModelAttribute Employee employee) {
		for (String skill : employee.getSkills()) {
			Skill sk = skillService.getSkillByName(skill);
			employee.getListSkill().add(sk);
		}

		employeeService.addEmployee(employee);
		String message = "Employee is successfully edited.";
		ModelAndView mav = new ModelAndView("EmployeeSuccess");
		mav.addObject("message", message);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		mav.addObject("listEmployee", listEmployee);
		return mav;

	}

}
