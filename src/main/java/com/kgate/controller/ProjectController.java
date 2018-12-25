package com.kgate.controller;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.kgate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.Employee;
import com.kgate.model.ProjectDetails;
import com.kgate.model.TaskDTO;
import com.kgate.model.TaskDetails;
import com.kgate.service.EmployeeService;
import com.kgate.service.ProjectService;
import com.kgate.service.TaskService;
import java.text.SimpleDateFormat;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectservice;

    @Autowired
    private TaskService taskservice;

    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    public void initConverter(WebDataBinder binder) {
        CustomDateEditor dateEditor = new CustomDateEditor(new ISO8601DateFormat(), true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @RequestMapping(value = "/cproject", method = RequestMethod.POST)
    public ModelAndView createProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails, @SessionAttribute("employee") Employee employee) {
        ModelAndView model = new ModelAndView("redirect:/cproject2");
//        ModelAndView model = new ModelAndView("CreateProject");
        projectDetails.setManageremail(employee.getEmail());
        projectservice.createProject(projectDetails);
        ProjectDetails pd = new ProjectDetails();
        List<ProjectDetails> listProject = projectservice.getProjectByEmail(employee.getEmail());
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
        List<ProjectDetails> listProject = projectservice.getProjectByEmail(employee.getEmail());
        System.out.println("List of Project:  " + listProject);
        mav.addObject("mid", mid);
        mav.addObject("pd", pd);
        mav.addObject("listProject", listProject);
        return mav;

    }

    @RequestMapping(value = "/showtask", method = RequestMethod.GET)
    public ModelAndView showtask(@SessionAttribute("employee") Employee employee, @ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {
        int pId = Integer.parseInt(request.getParameter("project_id"));
//        int pId = taskdetails.getProjectId();
//        int mId = taskdetails.getManagerId();
        taskdetails.setProjectId(pId);
        Integer mid = projectservice.getManagerid(employee.getEmail());
//        int mId = Integer.parseInt(request.getParameter("mgrid"));
        taskdetails.setManagerId(mid);
        System.out.println("Project ID::::    " + pId + "Manager ID::::::    " + mid);
        ModelAndView mav = new ModelAndView("createtask");
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        mav.addObject("task_Type", Tasktype);
//        List<TaskDetails> listtask = taskservice.getAllTask();
        List<TaskDetails> listtask = taskservice.getByProjectId(pId);
        System.out.println("List of task:  " + listtask);
        mav.addObject("taskdetails", taskdetails);
        TaskDetails td = new TaskDetails();
        mav.addObject("td", td);
        mav.addObject("listtask", listtask);
        Employee e = new Employee();
        mav.addObject("e", employeeService.searchByEmail(employee.getEmail()));

        return mav;
    }

    /*@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteTask(@ModelAttribute("taskdetails") TaskDetails taskdetails,HttpServletRequest request,@SessionAttribute("employee") Employee employee) {
        int task_id = Integer.parseInt(request.getParameter("taskid"));
        taskservice.deleteTask(task_id);
      ModelAndView mav = new ModelAndView("deletetask");
        return mav ;
    }*/
    @RequestMapping(value = "/delete1", method = RequestMethod.GET)
    public ModelAndView deleteTask(HttpServletRequest request) {
        int task_id = Integer.parseInt(request.getParameter("taskid"));
        taskservice.deleteTask(task_id);
        /*tring[] Tasktype= {"Coding","Design","Integration","Quality","Testing"};
    	mav.addObject("task_Type",Tasktype);
    	 List<TaskDetails> listtask =taskservice.getByProjectId(pId);
         System.out.println("List of task:  " + listtask);
         mav.addObject("td", taskdetails);
         mav.addObject("listtask", listtask);*/
        return new ModelAndView("redirect:/deleteTask");
    }

    @RequestMapping(value = "/backtoproject", method = RequestMethod.GET)
    public ModelAndView back(@ModelAttribute("employee") Employee employee, @RequestParam("email") String email) {

        ModelAndView mav = new ModelAndView("CreateProject");

        Integer mid = projectservice.getManagerid(email);
        mav.addObject("mid", mid);

        ProjectDetails pd = new ProjectDetails();
        mav.addObject("pd", pd);

        TaskDetails taskdetails = new TaskDetails();
        mav.addObject("taskdetails", taskdetails);

        Employee e = new Employee();
        e = employeeService.searchByEmail(employee.getEmail());
        mav.addObject("e", e);

        List<ProjectDetails> listProject = projectservice.getProjectByEmail(employee.getEmail());
        System.out.println("List of Project:  " + listProject);
        mav.addObject("listProject", listProject);

        return mav;

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteTask(@ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request, @SessionAttribute("employee") Employee employee) {
        ModelAndView mav = new ModelAndView("createtask");
        int task_id = Integer.parseInt(request.getParameter("taskid"));
        taskservice.deleteTask(task_id);
        int pId = taskdetails.getProjectId();
        taskdetails.setProjectId(pId);

        int mId = taskdetails.getManagerId();
        taskdetails.setManagerId(mId);

        taskdetails.setStatus("Not Assigned");
        taskservice.addTask(taskdetails);
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        mav.addObject("task_Type", Tasktype);
        List<TaskDetails> listtask = taskservice.getByProjectId(pId);
        System.out.println("List of task:  " + listtask);
        mav.addObject("td", taskdetails);
        mav.addObject("listtask", listtask);
        Employee e = new Employee();
        e.setEmail(taskdetails.getEmp_Email());
        mav.addObject("e", employeeService.searchByEmail(employee.getEmail()));

        return mav;
    }

    @RequestMapping(value = "/createtask", method = RequestMethod.POST)
    public ModelAndView taskcreate(@ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request, @SessionAttribute("employee") Employee employee) {
        ModelAndView mav = new ModelAndView("createtask");

        int pId = taskdetails.getProjectId();
        taskdetails.setProjectId(pId);

        int mId = taskdetails.getManagerId();
        taskdetails.setManagerId(mId);

        taskdetails.setStatus("Not Assigned");
        taskservice.addTask(taskdetails);
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        mav.addObject("task_Type", Tasktype);
        List<TaskDetails> listtask = taskservice.getByProjectId(pId);
        System.out.println("List of task:  " + listtask);
        mav.addObject("td", taskdetails);
        mav.addObject("listtask", listtask);
        Employee e = new Employee();
        e.setEmail(taskdetails.getEmp_Email());
        mav.addObject("e", employeeService.searchByEmail(employee.getEmail()));

        return mav;
    }

//    @RequestMapping(value = "/createtask2", method = RequestMethod.GET)
//    public ModelAndView taskcreatee(@ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {
//        int pId = taskdetails.getProjectId();
//        taskdetails.setProjectId(pId);
//        int mId = taskdetails.getManagerId();
//        taskdetails.setManagerId(mId);
//        ModelAndView mav = new ModelAndView("createtask");
//        taskdetails.setStatus("Not Assigned");
//        taskservice.addTask(taskdetails);
//        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
//        mav.addObject("task_Type", Tasktype);
//        List<TaskDetails> listtask = taskservice.getByProjectId(pId);
//        System.out.println("List of task:  " + listtask);
//        mav.addObject("td", taskdetails);
//        mav.addObject("listtask", listtask);
//        return mav;
//    }
    //CEO Project related
    @RequestMapping(value = "/displayProjectDetails", method = RequestMethod.GET)
    public ModelAndView displayProjectDetails(HttpServletRequest request) {
        int project_id = Integer.parseInt(request.getParameter("project_id"));
//        System.out.println("Project Name::::    " + projectName);
        ModelAndView mav = new ModelAndView("projectStatus");

        List<TaskDTO> listProject = projectservice.displayAllStatus(project_id);
        TaskDTO d = new TaskDTO();
        mav.addObject("listProject", listProject);
        System.out.println("EmployeeName;::::::::  " + listProject.get(0).getEmp_name());
        System.out.println("List of Project::::::   " + listProject);
        mav.addObject("d", d);

        return mav;
    }

    @RequestMapping(value = "/downloadReport", method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("project_id") String project_id, HttpServletRequest request) {
//         int project_id = Integer.parseInt(request.getParameter("project_id"));
//        int project_id = (Integer.BYTES).project_id;
        int id = Integer.parseInt(project_id);
        List<TaskDTO> listProject = projectservice.displayAllStatus(id);
        return new ModelAndView("pdfReport", "listProject", listProject);
    }

}
