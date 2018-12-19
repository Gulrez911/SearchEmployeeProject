package com.kgate.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.kgate.model.ProjectDetails;
import com.kgate.service.ProjectService;

public class ProjectTaskController 
{
	private static final Logger logger = Logger.getLogger(ProjectTaskController.class);
   @Autowired
   ProjectService projectservice;
   
   @RequestMapping(value ="/createproject",method = RequestMethod.GET)
   public ModelAndView createProject(ProjectDetails p)
   {
	   ModelAndView model=new ModelAndView("success");
	   if (p.getProject_id()==0)
	   {
		   projectservice.createProject(p);
	   }
	   List<ProjectDetails> pdlist=projectservice.dispalyProjects();
	   model.addObject("pdlist", pdlist);
	return model;
	   
   }
  
 
}
