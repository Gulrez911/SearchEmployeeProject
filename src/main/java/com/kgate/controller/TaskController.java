package com.kgate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.kgate.model.Employee;
import com.kgate.model.Skill;
import com.kgate.model.TaskDTO;
import com.kgate.model.TaskDetails;
import com.kgate.service.EmployeeService;
import com.kgate.service.SkillService;
import com.kgate.service.TaskService;

@Controller
public class TaskController {

    @Autowired
    TaskService taskservice;
    @Autowired
    SkillService skillService;
    @Autowired
    EmployeeService employeeService;

    @InitBinder
    public void initConverter(WebDataBinder binder) {
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @RequestMapping(value = "/editTask", method = RequestMethod.POST)
    public ModelAndView updateTask(@ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {

//		ModelAndView mav = new ModelAndView("EmployeeDashboard1");
        ModelAndView mav = new ModelAndView("redirect:/returnTask");
        String st = taskdetails.getStatus();
        String st1 = st.split(",")[0];

        List<TaskDetails> tlist = taskservice.getalltaskdetails(taskdetails.getEmp_Email());
        List<TaskDTO> tdto = taskservice.getEmpTasklist(taskdetails.getEmp_Email());
        String[] taskStatus = {"W.I.P.", "complete"};
        mav.addObject("taskStatus", taskStatus);
        mav.addObject("tobj", tdto);
        /*mav.addObject(employee);*/
        Employee employee = new Employee();
        employee.setEmail(taskdetails.getEmp_Email());
        mav.addObject(employee);
        Date d1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(d1);

        taskservice.updatetask1(date1, taskdetails.getEmp_Email(), taskdetails.getTask_id(), st1);
        return mav;

    }

    @RequestMapping(value = "/editlink1", method = RequestMethod.GET)
    public ModelAndView updateTask2(@ModelAttribute("taskdetails") TaskDetails taskdetails,
            @ModelAttribute("employee") Employee employee, @RequestParam("tid") int tid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("EmployeTaskEdit");
//        ModelAndView mav = new ModelAndView("redirect:/returnTask");
        String mail = request.getParameter("mail");
        List<TaskDetails> tlist = taskservice.getalltaskdetails(mail);
        mav.addObject("tlist", tlist);
        int tid1 = Integer.parseInt(request.getParameter("tid"));
        taskdetails = taskservice.getEmployeeTask(tid1);
        mav.addObject("taskdetails", taskdetails);
        String[] taskStatus = {"W.I.P.", "complete"};
        mav.addObject("taskStatus", taskStatus);
        return mav;

    }

    @RequestMapping(value = "/etasklist", method = RequestMethod.POST)
    public ModelAndView employeeTaskList(@ModelAttribute("taskdetails") TaskDetails taskdetails, @RequestParam("email") String email, @ModelAttribute("employee") Employee employee, @RequestParam("status") String status, ModelMap modelMap) {

        ModelAndView mav = new ModelAndView("EmployeeDashboard1");

        // System.out.println("List of EmployeeSkill: " + employeeSkill);
        if (status.equals("Approved")) {
            taskdetails = new TaskDetails();
            mav.addObject("taskdetails", taskdetails);
//            List<TaskDetails> tlist = taskservice.getalltaskdetails(email);
//            System.out.println("From Controller:::: list of :::   " + tlist);
            List<TaskDTO> tobj = new ArrayList<TaskDTO>();
            tobj = taskservice.getEmpTasklist(email);
            System.out.println("From Controller:::: list of Object:::   " + tobj);
            mav.addObject("tobj", tobj);
            TaskDTO taskObj = new TaskDTO();
            mav.addObject("taskObj", taskObj);
//            mav.addObject("tlist", tlist);
            mav.addObject("mail", email);
            String[] taskStatus = {"W.I.P.", "Complete"};
            mav.addObject("taskStatus", taskStatus);

            mav.addObject("employee", employee);
        } else {

            modelMap.put("error", "Please Edit Details For Make Status Approved");
            mav = new ModelAndView("byEmployeeEdit");

            Employee emp = employeeService.searchByEmail(employee.getEmail());
            List<String> employeeSkill
                    = skillService.getEmployeeSkillByEmail(employee.getEmail());

            System.out.println("List of EmployeeSkill: " + employeeSkill);

            List<Skill> listSkill = skillService.getAllSkills();

            List<String> sk = new ArrayList<>();

            for (int i = 0; i < employeeSkill.size(); i++) {
                Object o = employeeSkill.get(i);
                String s = (String) o;
                sk.add(s);
            }
            emp.setSkills(sk);
            String[] userType = {"Employee", "Admin", "Manager"};
            mav.addObject("userTypes", userType);

            mav.addObject("listSkill", listSkill);
            mav.addObject("employee", emp);

            Skill skill = new Skill();
            mav.addObject("skill", skill);

            return mav;
        }

        return mav;

    }

    @RequestMapping(value = "/returnTask", method = RequestMethod.GET)
    public ModelAndView returnTasklist(@ModelAttribute("taskdetails") TaskDetails taskdetails) {
        ModelAndView mav = new ModelAndView("EmployeeDashboard1");
         mav.addObject("taskdetails", taskdetails);
        return mav;
    }
}

