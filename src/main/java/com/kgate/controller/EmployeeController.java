package com.kgate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.kgate.model.Employee;
import com.kgate.model.Skill;
import com.kgate.service.EmployeeService;
import com.kgate.service.SkillService;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private static final Logger logger = Logger
            .getLogger(EmployeeController.class);

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/search_employeelist")
    public ModelAndView searchEmployee(ModelAndView model, @RequestParam("freeText") String freeText) throws IOException {
        List<Employee> listEmployee = employeeService.searchEmployees(freeText);
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/search_employeelist_skill")
    public ModelAndView searchEmployeeBySkill(ModelAndView model, @RequestParam("skillSearch") String skillSearch) throws IOException {
        List<Employee> listEmployee = employeeService.searchEmployeesBySkill(skillSearch);
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    //with validation
    @RequestMapping(value = "/employeelist")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
//        Skill skill = new Skill();
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
//        model.addObject("skill", skill);
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("EmployeeForm");
        return model;
    }

//     @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
//    public ModelAndView saveEmployee(@ModelAttribute Employee employee, BindingResult result) {
//        if(result.hasErrors()){
//            ModelAndView andView = new ModelAndView("EmployeeForm");
//            return andView;
//        }
//        for (String skill : employee.getSkills()) {
//            Skill sk = skillService.getSkillByName(skill);
//            employee.getListSkill().add(sk);
//        }
//
//        if (employee.getId() == 0) { // if employee id is 0 then creating the
//            // employee other updating the employee
//
//            employeeService.addEmployee(employee);
//        } else {
//            employeeService.updateEmployee(employee);
//        }
//        return new ModelAndView("redirect:/employeelist");
//    }
    
    
    
    
    
//    @RequestMapping(value = "/loginsuccess", method = RequestMethod.POST)
//	public String doLogin(@Valid @ModelAttribute("employee") Employee employee,
//			BindingResult result, Map<String, Object> model) {
//
//		if (result.hasErrors()) {
//			return "LoginForm";
//		}
//
//		return "LoginSuccess";
//
//        }
         
       
       
    
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        for (String skill : employee.getSkills()) {
            Skill sk = skillService.getSkillByName(skill);
            employee.getListSkill().add(sk);
        }

        if (employee.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee

            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }

        if (result.hasErrors()) {
            return new ModelAndView("EmployeeForm");
        }

        return new ModelAndView("redirect:/employeelist");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/employeelist");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));

        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
        model.addObject("employee", employee);

        return model;
    }

}
