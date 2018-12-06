package com.kgate.controller;

import com.kgate.model.User;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.kgate.model.Employee;
import com.kgate.model.Skill;
import com.kgate.model.User;
import com.kgate.service.EmployeeService;
import com.kgate.service.LoginService2;
import com.kgate.service.SkillService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;


@Controller
 //@RequestMapping(value = ("/"))
public class UserController {
	
	@Autowired
    private LoginService2 loginservice2;
 
 @Autowired
    private SkillService skillService;
    
  
    public void setloginService1(LoginService2 loginservice2) {
       this.loginservice2=loginservice2; 
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init() {
    	 
    	 ModelAndView mav = new ModelAndView("login");
           User user = new User();
	        mav.addObject("user", user);
	        String[] userType = {"Admin", "Employee","Manager"};
	        mav.addObject("userTypes", userType);
			return mav;
     }
    /* @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
     public ModelAndView newContact(ModelAndView model) {
//         Skill skill = new Skill();
         List<Skill> listSkill = skillService.getAllSkills();
         model.addObject("listSkill", listSkill);
//         model.addObject("skill", skill);
         Employee employee = new Employee();
         model.addObject("employee", employee);
         model.setViewName("EmployeeForm");
         return model;
     }*/
     
    /*public String submit(ModelMap modelMap, @ModelAttribute("loginModel") @Valid User user) {*/
    /* //     System.out.println("in submit" + user);
          String password = user.getPassword();
          if (password != null && password.equals("admin")) {
              modelMap.put("userInfo", user.getUserName());
              return "success";
          } else {
              modelMap.put("error", "Invalid UserName / Password");
              return "login";
          }
  }*/
      	
    /*@RequestMapping(value = "/", method = RequestMethod.POST)
   	    public ModelAndView homepg(Model m) {
   	        
   	    	 ModelAndView mav = new ModelAndView("login");
   	       	User user = new User();
   	        mav.addObject("user", user);
   	        String userType[] = {"Admin", "Employee","Manager"};
   	        mav.addObject("userTypes", userType);
   	        return mav;
   	        }*/

    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView authenticate(ModelMap modelMap,@ModelAttribute("User") User u,HttpServletRequest request, Map<String, Object> map) {
           
            /* validate whether person is in database and person user and password
             are matching
            */

         boolean isValidUser = loginservice2.checkLogin(u);

         if (isValidUser) {
         if (u.getCategory().equals("Admin")) {
                   
                     /*Get all data required for Person jsp and set in ModelAndView*/
                    
   	               
   	                
   	       request.setAttribute("loginuser",u.getUserName());

                ModelAndView mav = new ModelAndView("success");
               return mav;
                 
              }
         
         else if(u.getCategory().equals("Manager"))
         {
        	 ModelAndView mav = new ModelAndView("Manager");
        	 return mav;
         }
         
         else if(u.getCategory().equals("Employee"))
         {
             
             /*Get all data required for Person jsp and set in ModelAndView*/
            
              
       	  ModelAndView mav = new ModelAndView("EditEmployee");
       	  request.setAttribute("loginuser",u.getUserName());
               List<Skill> listSkill = skillService.getAllSkills();
   	        mav.addObject("listSkill", listSkill);
   	        Employee employee = new Employee();
   	        mav.addObject("employee", employee);
   	        return mav;
   	        
         
      }
         else {
       	    modelMap.put("error", "Invalid UserName / Password");
       	    ModelAndView mav = new ModelAndView("login");
               return mav;
            
       	  
         }
    
        	
    

   
   	
    }
		return init();
   }
}


    
    
	
	
 
 
