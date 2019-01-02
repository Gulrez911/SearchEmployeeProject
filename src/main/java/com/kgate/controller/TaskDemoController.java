package com.kgate.controller;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.kgate.model.Employee;
import com.kgate.model.TaskDetails;
import com.kgate.service.ProjectService;
import com.kgate.service.TaskService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@SessionAttributes("taskDetails")
public class TaskDemoController {

    @Autowired
    TaskService taskService;

    @Autowired
    ProjectService projectService;

    @InitBinder
    public void initConverter(WebDataBinder binder) {
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @RequestMapping(value = "/asssign", method = RequestMethod.GET)

    public ModelAndView allotTask(HttpServletRequest request, @SessionAttribute("employee") Employee employee) {
        ModelAndView model = new ModelAndView("AllocateTask");
        int taskId = Integer.parseInt(request.getParameter("task_id"));
        TaskDetails td2 = taskService.getTask(taskId);
        List<String> employeeEmail = taskService.getEmployeeEmail(employee.getEmail());

        model.addObject("td", td2);
        model.addObject("employeeEmail", employeeEmail);

        String bk = request.getParameter("em");

        model.addObject("em", bk);

        return model;
    }

    @RequestMapping(value = "/taskAllocated", method = RequestMethod.POST)
    public ModelAndView success(@ModelAttribute("TaskDetails") TaskDetails TaskDetails,
            @ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {
        taskdetails.setStatus("Assigned");
        taskdetails.setTaskStatus("W .I. P");
        int mId = TaskDetails.getManagerId();
        taskdetails.setManagerId(mId);
        int pId = TaskDetails.getProjectId();
        taskdetails.setProjectId(pId);
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        List<TaskDetails> listtask = taskService.getTaskList(pId);
        /* int pId = taskdetails.getProjectId(); */

 /* int mId = taskdetails.getManagerId(); */
        System.out.println("Project ID::::    " + pId + "Manager ID::::::    " + mId);

//        ModelAndView mav = new ModelAndView("createtask");
        ModelAndView mav = new ModelAndView("redirect:/taskSubmit");

        String ProjectName = projectService.displayProjectName(pId);
        System.out.println("Project Name::::::::::::" + ProjectName);
        mav.addObject("task_Type", Tasktype);
//		List<TaskDetails> listtask = taskService.getAllTask();

        System.out.println("List of task:  " + listtask);
        taskService.addTask(taskdetails);
        mav.addObject("taskdetails", taskdetails);

        mav.addObject("listtask", listtask);
        TaskDemoController tdc = new TaskDemoController();

        String s = request.getParameter("em");
        mav.addObject("em", s);

        String tskName = taskdetails.getTask_Name();
        String tskType = taskdetails.getTask_Type();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String tStartDate = dateFormat.format(taskdetails.gettStart_Time());
        String tEndDate = dateFormat.format(taskdetails.gettEnd_Time());
        System.out.println("Employee Email:::: " + taskdetails.getEmp_Email());

        /*
		 * tdc.sendMail(taskdetails.getEmp_Email(), "Your Task Details:  \nTask Type:  "
		 * + taskdetails.getTask_Type() + "\nTaskName::: " + taskdetails.getTask_Name(),
		 * "You have been assigned a Task");
         */
        String message = "<i>You have been assigned a task</i><br>";
        message += "<font color=red>Task Details are as below</font>";
        message += "<table border='1'><th>Project Name</th><th>Task Name</th><th> Task Type</th><th> Task Start Date</th><th> Task End Date</th><tr><td>"
                + ProjectName + "</td><td>" + tskName + "</td><td>" + tskType + "</td><td>" + tStartDate + "</td><td>"
                + tEndDate + "</td></tr></table>";
        tdc.sendMail(taskdetails.getEmp_Email(), message, "You have been assigned a task");
        return mav;
    }
 

    public void sendMail(String to, String message, String subject) {

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
            /* message1.setText(message); */
            message1.setContent(message, "text/html");
            Transport.send(message1);

            System.out.println("Done");

        } catch (MessagingException e1) {
            throw new RuntimeException(e1);
        }
        // return "employeelist";

    }

}
