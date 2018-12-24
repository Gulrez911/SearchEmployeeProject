package com.kgate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgate.dao.TaskDao;
import com.kgate.model.Employee;
import com.kgate.model.ProjectDetails;
import com.kgate.model.Skill;
import com.kgate.model.TaskDetails;
import com.kgate.service.EmployeeService;
import com.kgate.service.LoginService2;
import com.kgate.service.ProjectService;
import com.kgate.service.SkillService;
import com.kgate.service.TaskService;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// @RequestMapping(value = ("/"))
@SessionAttributes("employee")
public class UserController {

    @Autowired
    private TaskService taskservice;

    @Autowired
    private LoginService2 loginservice2;

    @Autowired
    private SkillService skillService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectservice;

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
        String[] userType = {"Admin", "Employee", "Manager", "CEO"};
        mav.addObject("userTypes", userType);
        return mav;
    }

    /*
	 * public ModelAndView ct() { ModelAndView mav=new ModelAndView("createtask");
	 * TaskDetails TaskDetails=new TaskDetails(); mav.addObject("task",TaskDetails);
	 * String[] Tasktype= {"Coding","Design","Integration","Quality","Testing"};
	 * mav.addObject("task_Type",Tasktype); return mav;
     */
 /*
	 * @RequestMapping(value= ,method = RequestMethod.GET) public ModelAndView
	 * addingtask() { ModelAndView mav=new ModelAndView("createtask");
	 * taskservice.addTask(); String message ="Task is successfully added"; return
	 * mav;
	 * 
	 * }
	 * 
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
                return mav;

            } else if (employee.getCategory().equals("Manager")) {

                ModelAndView mav = new ModelAndView("CreateProject");


                Integer mid = projectservice.getManagerid(employee.getEmail());
                // System.out.println("Manager ID:::: " + mid);
                mav.addObject("mid", mid);
                ProjectDetails projectdetails = new ProjectDetails();
              projectdetails.setManageremail(employee.getEmail());
                TaskDetails taskdetails = new TaskDetails();
                ProjectDetails pd = new ProjectDetails();
                mav.addObject("projectdetails", projectdetails);
                taskdetails.setEmp_Email(employee.getEmail());
                mav.addObject("taskdetails", taskdetails);
                Employee e = new Employee();
                mav.addObject("e", employeeService.searchByEmail(employee.getEmail()));
                List<ProjectDetails> listProject = projectservice.getProjectByEmail(employee.getEmail());
                // System.out.println("List of Project: " + listProject);
                mav.addObject("pd", pd);
                
                mav.addObject("listProject", listProject);


                return mav;

            } else if (employee.getCategory().equals("Employee")) {

                /* Get all data required for Person jsp and set in ModelAndView */
                // ModelAndView mav = new ModelAndView("byEmployeeEdit");
                // Employee emp = employeeService.searchByEmail(employee.getEmail());
                // List<String> employeeSkill =
                // skillService.getEmployeeSkillByEmail(employee.getEmail());

                /*	ModelAndView mav = new ModelAndView("EmployeeDashboard1");
				// System.out.println("List of EmployeeSkill: " + employeeSkill);
				TaskDetails taskdetails = new TaskDetails();
				mav.addObject("taskdetails", taskdetails);
				List<TaskDetails> tlist = taskservice.getalltaskdetails(email);
				mav.addObject("mail", email);
				String[] taskStatus = { "W.I.P.", "Complete" };
				mav.addObject("taskStatus", taskStatus);
				mav.addObject("tlist", tlist);
				mav.addObject("employee", employee);
				return mav;*/
                ModelAndView mav = new ModelAndView("byEmployeeEdit");

                Employee emp = employeeService.searchByEmail(employee.getEmail());
                List<String> employeeSkill
                        = skillService.getEmployeeSkillByEmail(employee.getEmail());

                System.out.println("List of EmployeeSkill: " + employeeSkill);

                List<Skill> listSkill = skillService.getAllSkills();

                List<String> sk = new ArrayList<>();

                for (int i = 0; i < employeeSkill.size(); i++) {
                    Object o = employeeSkill.get(i);
                    String s = (String) o;
                    sk.add(s);
                }
                emp.setSkills(sk);
                String[] userType = {"Employee", "Admin", "Manager"};
                mav.addObject("userTypes", userType);

                mav.addObject("listSkill", listSkill);
                mav.addObject("employee", emp);

                Skill skill = new Skill();
                mav.addObject("skill", skill);
                return mav;

            } else if (employee.getCategory().equals("CEO")) {
                ModelAndView model = new ModelAndView("CEODashboard");
                List<ProjectDetails> listProject = projectservice.dispalyProjects();
                ProjectDetails pd = new ProjectDetails();
                model.addObject("pd", pd);
                model.addObject("listProject", listProject);

                return model;
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
//	@RequestMapping(value = "/byEmployeeEdit", method = RequestMethod.POST)
//	public ModelAndView byEmployeeEdit(@ModelAttribute Employee employee) {
//		for (String skill : employee.getSkills()) {
//			Skill sk = skillService.getSkillByName(skill);
//			employee.getListSkill().add(sk);
//		}
//
//		employeeService.addEmployee(employee);
//		String message = "Employee is successfully edited.";
//		ModelAndView mav = new ModelAndView("EmployeeSuccess");
//		mav.addObject("message", message);
//		List<Employee> listEmployee = employeeService.getAllEmployees();
//		mav.addObject("listEmployee", listEmployee);
//		return mav;
//
//	}
    @RequestMapping(value = "/Empedit", method = RequestMethod.POST)
	public ModelAndView Empedit(@ModelAttribute Employee employee) {
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
         String[] userType = {"Employee", "Admin", "Manager"};
         mav.addObject("userTypes", userType);

         mav.addObject("listSkill", listSkill);
         mav.addObject("employee", emp);

         Skill skill = new Skill();
         mav.addObject("skill", skill);
         return mav;

	}
	
}
