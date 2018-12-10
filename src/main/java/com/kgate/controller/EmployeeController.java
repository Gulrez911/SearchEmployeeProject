package com.kgate.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import com.kgate.model.User;
import com.kgate.service.EmployeeService;

import com.kgate.service.SkillService;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    public String generateOTP() {
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        return id;
    }

    @RequestMapping(value = "/search_employeelist")
    public ModelAndView searchEmployee(ModelAndView model, @RequestParam("freeText") String freeText)
            throws IOException {
        List<Employee> listEmployee = employeeService.searchEmployees(freeText);
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }
//original method for skill search

    @RequestMapping(value = "/search_employeelist_skill")
    public ModelAndView searchEmployeeBySkill(ModelAndView model, @RequestParam("skillSearch") String skillSearch)
            throws IOException {
        List<Employee> listEmployee = employeeService.searchEmployeesBySkill(skillSearch);
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/search_employeelist_skill1")
    public ModelAndView searchEmployeeBySkill1(ModelAndView model, @RequestParam("skillSearch") String skillSearch)
            throws IOException {

        int flag = 1;

        List<Skill> listSkill = skillService.getAllSkills();
        if (skillSearch.length() > 2) {
            for (Skill s : listSkill) {
                String a = s.getSkill_name().toLowerCase();
                if (a.contains(skillSearch)) {
                    List<Employee> listEmployee = employeeService.searchEmployeesBySkill(a);
                    model.addObject("listEmployee", listEmployee);
                    flag = 0;
                }
            }

        } else {
            model.addObject("error", "data not found");
            model.setViewName("home");
            return model;
        }
        if (flag == 1) {
            model.addObject("error", "data not found");
            model.setViewName("home");
            return model;
        }
        model.setViewName("home");
        return model;

    }

    // with validation
    @RequestMapping(value = "/employeelist")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
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

        String[] userType = {"Employee", "Admin", "Manager"};
        model.addObject("userTypes", userType);
        /*   
	    String[] manageremail = managerservice.getAllManagerByEmail();
	    model.addObject("userTypes", userType);*/
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
    @RequestMapping(value = "/saveEmployee", params = "action1", method = RequestMethod.POST)
    public ModelAndView sendOTPAction(@ModelAttribute("employee") Employee employee) {

        for (String skill : employee.getSkills()) {
            Skill sk = skillService.getSkillByName(skill);
            employee.getListSkill().add(sk);
        }

        EmployeeController ec = new EmployeeController();
        String temp_otp = ec.generateOTP();
        employee.setOtp(temp_otp);
        employee.setStatus("Not Approved");
        employeeService.addEmployee(employee);
//        System.out.println("otp: " + temp_otp);
        ec.sendMail("pawarvihan5@gmail.com", temp_otp, "confirm message");
        ModelAndView model = new ModelAndView();
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
//        model.addObject("employee", employee);

        String[] userType = {"Admin", "Employee", "Manager"};
        model.addObject("userTypes", userType);
        model.setViewName("EmployeeForm");
        return model;
    }

    @RequestMapping(value = "/saveEmployee", params = "action2", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        /* if (employee.getOtp().equals(temp_3)) { */
//            System.out.println("OTP: " + temp_3);

        for (String skill : employee.getSkills()) {
            Skill sk = skillService.getSkillByName(skill);
            employee.getListSkill().add(sk);
        }

        Employee emp = employeeService.searchByEmail(employee.getEmail());
        if (emp == null) {
            throw new RuntimeException("cannnot be null");
        } else {
            if (employee.getOtp().equals(emp.getOtp())) {
//                emp.setStatus("Approved");
                employee.setStatus("Approved");
//                employeeService.addEmployee(emp);
                employeeService.addEmployee(employee);
            } else {
                // send him a message that otp is invalid
                return new ModelAndView("invalid");
            }
        }
//           String password=employee.getPassword();
        EmployeeController ec = new EmployeeController();
        ec.sendMail(employee.getEmail(), "OTP:" + employee.getOtp() + "\n password:" + employee.getPassword(),
                "confirm message");
        return new ModelAndView("redirect:/employeelist");
    }

    public void sendMail(String to, String message, String subject) {
        final Employee e = new Employee();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gulfarooqui1@gmail.com", "Gulrez#7326");
            }
        });

        Message message1 = new MimeMessage(session);

        try {

            message1.setFrom(new InternetAddress("test@gmail.com"));
            message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message1.setSubject(subject);
            message1.setText(message);

            Transport.send(message1);

            System.out.println("Done");

        } catch (MessagingException e1) {
            throw new RuntimeException(e1);
        }
        // return "employeelist";

    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/employeelist");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));

        List<String> employeeSkill = skillService.getEmployeeSkill(employeeId);
        System.out.println("List of EmployeeSkill:   " + employeeSkill);
        Employee employee = employeeService.getEmployee(employeeId);

        ModelAndView model = new ModelAndView("edit");
        List<Skill> listSkill = skillService.getAllSkills();

        List<String> sk = new ArrayList<>();

        for (int i = 0; i < employeeSkill.size(); i++) {
            Object o = employeeSkill.get(i);
            String s = (String) o;
            sk.add(s);
        }
        employee.setSkills(sk);
        String[] userType = {"Employee", "Admin", "Manager"};
        model.addObject("userTypes", userType);

        model.addObject("listSkill", listSkill);
        model.addObject("employee", employee);

        Skill skill = new Skill();
        model.addObject("skill", skill);
        return model;
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    public ModelAndView updateperson(@ModelAttribute Employee employee) {
        for (String skill : employee.getSkills()) {
            Skill sk = skillService.getSkillByName(skill);
            employee.getListSkill().add(sk);
        }

        employeeService.addEmployee(employee);
        String message = "Employee is successfully edited.";
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", message);
        List<Employee> listEmployee = employeeService.getAllEmployees();
        mav.addObject("listEmployee", listEmployee);
        return mav;

    }

    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadPDF() {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        return new ModelAndView("pdfView", "listEmployee", listEmployee);
    }

    @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        return new ModelAndView("excelView", "listEmployee", listEmployee);
    }

}
