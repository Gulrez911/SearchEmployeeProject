package com.kgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.ProjectDetails;
import com.kgate.service.ProjectService;
import java.util.List;

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

    @RequestMapping(value = "/cproject", method = RequestMethod.POST)
    public ModelAndView createProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) {
        ModelAndView model = new ModelAndView("redirect:/cproject2");
        projectservice.createProject(projectDetails);
        ProjectDetails pd = new ProjectDetails();
        List<ProjectDetails> listProject = projectservice.dispalyProjects();
        model.addObject("listProject ", listProject);
        model.addObject("pd", pd);
        return model;


    }

    @RequestMapping(value = "/cproject2", method = RequestMethod.GET)
    public ModelAndView createProject2(@ModelAttribute("projectDetails") ProjectDetails projectDetails) {
        ModelAndView mav = new ModelAndView("CreateProject");
        ProjectDetails projectdetails = new ProjectDetails();
        ProjectDetails pd = new ProjectDetails();
        mav.addObject("projectdetails", projectdetails);
        List<ProjectDetails> listProject = projectservice.dispalyProjects();
        System.out.println("List of Project:  " + listProject);
        mav.addObject("pd", pd);
        mav.addObject("listProject", listProject);
        return mav;

    }

	@RequestMapping(value = "/showproject", method = RequestMethod.POST)
	public ModelAndView showProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) 
	{
		return null;
	
	}
}
