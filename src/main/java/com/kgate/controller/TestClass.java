/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.Employee;
import com.kgate.model.ProjectDetails;
import com.kgate.service.ProjectService;

/**
 *
 * @author user
 */
@Controller
public class TestClass {

	@Autowired
	ProjectService projectservice;

	@RequestMapping(value = "/cproject", method = RequestMethod.POST)
	public ModelAndView createProject(@ModelAttribute("projectDetails") ProjectDetails projectDetails) {
		// ModelAndView model = new ModelAndView();
		ModelAndView model = new ModelAndView("success");
		 projectservice.createProject(projectDetails);
		
		   
		// List<ProjectDetails> pdlist = projectservice.dispalyProjects();

		// model.addObject("projectdetails", projectdetails);
		// model.addObject("pdlist", pdlist);
		// model.setViewName("DashBordManager");

		return model;

	}
}
