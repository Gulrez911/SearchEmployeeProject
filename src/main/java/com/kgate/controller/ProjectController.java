package com.kgate.controller;

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

		return model;

	}

}
