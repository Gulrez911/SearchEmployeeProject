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
public class ProjectTaskController {
	// private static final Logger logger =
	// Logger.getLogger(ProjectTaskController.class);
	@Autowired
	ProjectService projectservice;
	//
	// public void setPersonService(ProjectService projectservice) {
	// this.projectservice = projectservice;
	// }

	// @RequestMapping(value = "/cproject", method = RequestMethod.POST)
	// public ModelAndView createProject(@ModelAttribute("projectdetails") ProjectDetails projectdetails) {
	// // ModelAndView model = new ModelAndView();
	// ModelAndView model = new ModelAndView("success");
	// projectservice.createProject(projectdetails);
	//
	// List<ProjectDetails> pdlist = projectservice.dispalyProjects();
	//
	// model.addObject("projectdetails", projectdetails);
	// model.addObject("pdlist", pdlist);
	// // model.setViewName("DashBordManager");
	//
	// return model;
	//
	// }

	// @RequestMapping(value = "/cproject", method = RequestMethod.POST)
	// public ModelAndView success() {
	// ModelAndView andView = new ModelAndView("success");
	//
	// return andView;
	// }
}
