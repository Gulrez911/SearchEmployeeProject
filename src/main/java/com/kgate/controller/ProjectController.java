package com.kgate.controller;

import com.kgate.model.Employee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDetails;
import com.kgate.service.EmployeeService;
import com.kgate.service.ProjectService;
import com.kgate.service.TaskService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProjectController {

    /*<<<<<<< HEAD
	@RequestMapping(value = "/cproject", method = RequestMethod.POST)
	public ModelAndView createProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) {
		ModelAndView model = new ModelAndView("success");
		projectservice.createProject(projectDetails);
		projectDetails = new ProjectDetails();
			List<ProjectDetails> pdlist = projectservice.dispalyProjects();
			 model.addObject("projectdetails", projectDetails);
			 model.addObject("pdlist", pdlist);
		return model;
=======*/
    @Autowired
    ProjectService projectservice;

    @Autowired
    private TaskService taskservice;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/cproject", method = RequestMethod.POST)
    public ModelAndView createProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) {
        ModelAndView model = new ModelAndView("redirect:/cproject2");
//        ModelAndView model = new ModelAndView("CreateProject");
        projectservice.createProject(projectDetails);
        ProjectDetails pd = new ProjectDetails();
        List<ProjectDetails> listProject = projectservice.dispalyProjects();
        model.addObject("listProject ", listProject);
        model.addObject("pd", pd);
        return model;

    }

    @RequestMapping(value = "/cproject2", method = RequestMethod.GET)
    public ModelAndView createProject2(@ModelAttribute("projectDetails") ProjectDetails projectDetails, @SessionAttribute("employee") Employee employee) {
        Integer mid = projectservice.getManagerid(employee.getEmail());
        ModelAndView mav = new ModelAndView("CreateProject");
        ProjectDetails projectdetails = new ProjectDetails();
        ProjectDetails pd = new ProjectDetails();
        mav.addObject("projectdetails", projectdetails);
        List<ProjectDetails> listProject = projectservice.dispalyProjects();
        System.out.println("List of Project:  " + listProject);
        mav.addObject("mid", mid);
        mav.addObject("pd", pd);
        mav.addObject("listProject", listProject);
        return mav;

    }

    @RequestMapping(value = "/showtask", method = RequestMethod.GET)
    public ModelAndView showtask(@ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {
//        int pId = Integer.parseInt(request.getParameter("project_id"));
//        taskdetails.setProjectId(pId);
//        int mId = Integer.parseInt(request.getParameter("mgrid"));
//        taskdetails.setManagerId(mId);
        ModelAndView mav = new ModelAndView("createtask");
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        mav.addObject("task_Type", Tasktype);
        List<TaskDetails> listtask = taskservice.getAllTask();
        System.out.println("List of task:  " + listtask);
        mav.addObject("td", taskdetails);
        mav.addObject("listtask", listtask);
        return mav;
    }

    @RequestMapping(value = "/createtask", method = RequestMethod.POST)
    public ModelAndView taskcreate(@ModelAttribute("taskdetails") TaskDetails taskdetails) {
        ModelAndView mav = new ModelAndView("createtask");
        taskdetails.setStatus("Not Assigned");
        taskservice.addTask(taskdetails);
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        mav.addObject("task_Type", Tasktype);
        List<TaskDetails> listtask = taskservice.getAllTask();
        System.out.println("List of task:  " + listtask);
        mav.addObject("td", taskdetails);
        mav.addObject("listtask", listtask);
        return mav;
    }
}
