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
import com.kgate.service.EmployeeService;
import com.kgate.service.SkillService;

import java.util.Map;
import java.util.Properties;
import java.util.Random;

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

    public String generateOTP() {
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        return id;
    }
    public String temp_otp = "";

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
    
    
    @RequestMapping(value = "/saveEmployee", params = "action1", method = RequestMethod.POST)
    public ModelAndView sendOTPAction(@ModelAttribute("employee") Employee employee) {

        EmployeeController ec = new EmployeeController();
        temp_otp = ec.generateOTP();
        demo(temp_otp);
        System.out.println("otp: " + temp_otp);
        ec.sendMail(employee.getEmail(), temp_otp, "confirm message");
        ModelAndView model = new ModelAndView();
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
//        model.addObject("employee", employee);
        model.setViewName("EmployeeForm");
        return model;
    }
    public String temp_3;

    public void demo(String temp_otp2) {
        this.temp_3 = temp_otp2;
    }

    @RequestMapping(value = "/saveEmployee", params = "action2", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getOtp().equals(temp_3)) {
            System.out.println("OTP: " + temp_3);
            for (String skill : employee.getSkills()) {
                Skill sk = skillService.getSkillByName(skill);
                employee.getListSkill().add(sk);
            }

            if (employee.getId() == 0) { // if employee id is 0 then creating the
                // employee other updating the employee

                employeeService.addEmployee(employee);
            } else {
                employeeService.addEmployee(employee);
            }

            EmployeeController ec = new EmployeeController();
            ec.sendMail(employee.getEmail(), "Employee is added Successfully", "confirm message");
            return new ModelAndView("redirect:/employeelist");
        } else {
            return new ModelAndView("invalid");
        }
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
        //    return "employeelist";

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
//        List<Skill> listSkill = skillService.getAllSkills();
//        model.addObject("listSkill", listSkill);
        model.addObject("employee", employee);

        return model;
    }

}
