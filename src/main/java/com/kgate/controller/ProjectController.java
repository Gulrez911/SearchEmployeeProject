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

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectservice;

	@RequestMapping(value = "/cproject", method = RequestMethod.POST)
	public ModelAndView createProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) {
		ModelAndView model = new ModelAndView("success");
		projectservice.createProject(projectDetails);
		projectDetails = new ProjectDetails();
			List<ProjectDetails> pdlist = projectservice.dispalyProjects();
			 model.addObject("projectdetails", projectDetails);
			 model.addObject("pdlist", pdlist);
		return model;

	}

	@RequestMapping(value = "/showproject", method = RequestMethod.POST)
	public ModelAndView showProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) 
	{
		return null;
	
	}
}
