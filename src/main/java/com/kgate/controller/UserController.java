package com.kgate.controller;

import com.kgate.model.User;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(value = ("/"))
public class UserController {

    @Autowired
    private LoginService2 loginservice2;

    @Autowired
    private SkillService skillService;

    @Autowired
    private EmployeeService employeeService;

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
        String[] userType = {"Admin", "Employee", "Manager"};
        mav.addObject("userTypes", userType);
        return mav;
    }

    @RequestMapping(value = "/Edit", method = RequestMethod.POST)
    public ModelAndView editByemployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        String message = "Employee is successfully edited.";
//		ModelAndView mav = new ModelAndView("EditEmployee");
        ModelAndView mav = new ModelAndView("testfile");
//		mav.addObject("message", message);

        return mav;

    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView authenticate(ModelMap modelMap, @ModelAttribute("employee") Employee employee, HttpServletRequest request, Map<String, Object> map, @RequestParam("email") String email) {

        /* validate whether person is in database and person user and password
             are matching
         */
        boolean isValidUser = loginservice2.checkLogin(employee.getEmail(), employee.getPassword());

        if (isValidUser) {
            if (employee.getCategory().equals("Admin")) {

                /*Get all data required for Person jsp and set in ModelAndView*/
                request.setAttribute("loginuser", employee.getEmail());

                ModelAndView mav = new ModelAndView("success");
                return mav;

            } else if (employee.getCategory().equals("Manager")) {
                ModelAndView mav = new ModelAndView("ManagerSuccess");
                List<Employee> elist = employeeService.displayByManagerId(email);
                mav.addObject("elist", elist);
                /*Employee e=new Employee();
        	mav.addObject("employee", e);*/
                return mav;

            } else if (employee.getCategory().equals("Employee")) {

                /*Get all data required for Person jsp and set in ModelAndView*/
                ModelAndView mav = new ModelAndView("EditEmployee");
                Employee emp = employeeService.searchByEmail(employee.getEmail());
                mav.addObject("employee", emp);
                List<String> employeeSkill = skillService.getEmployeeSkillByEmail(employee.getEmail());
                System.out.println("List of EmployeeSkill:   " + employeeSkill);

                List<Skill> listSkill = skillService.getAllSkills();

                List<String> sk = new ArrayList<>();

                for (int i = 0; i < employeeSkill.size(); i++) {
                    Object o = employeeSkill.get(i);
                    String s = (String) o;
                    sk.add(s);
                }

                employee.setSkills(sk);

                mav.addObject("listSkill", listSkill);

                Skill skill = new Skill();
                mav.addObject("skill", skill);

                return mav;

            } else {
                modelMap.put("error", "Invalid UserName / Password");
                ModelAndView mav = new ModelAndView("login");
                return mav;

            }

        }
        modelMap.put("error", "Invalid UserName / Password");
        return init();
    }

}
