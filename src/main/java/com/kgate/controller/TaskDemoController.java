package com.kgate.controller;

import com.kgate.model.Employee;
import com.kgate.model.TaskDetails;
import com.kgate.service.TaskService;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskDemoController {

    @Autowired
    TaskService taskService;

    @InitBinder
    public void initConverter(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
    }

   @RequestMapping(value = "/asssign", method = RequestMethod.GET)
    public ModelAndView allotTask(HttpServletRequest request, @SessionAttribute("employee") Employee employee) {
        ModelAndView model = new ModelAndView("AllocateTask");
        int taskId = Integer.parseInt(request.getParameter("task_id"));
        TaskDetails td2 = taskService.getTask(taskId);
        List<String> employeeEmail = taskService.getEmployeeEmail(employee.getEmail());
        model.addObject("td", td2);
        model.addObject("employeeEmail", employeeEmail);

        return model;
    }

    
   /* @RequestMapping(value = "/asssign", method = RequestMethod.GET)
    public ModelAndView allotTask(HttpServletRequest request, @SessionAttribute("employee") Employee employee) {
        ModelAndView model = new ModelAndView("AllocateTask");
        int task_Id = Integer.parseInt(request.getParameter("taskid"));
        int taskId = Integer.parseInt(request.getParameter("task_id"));
        TaskDetails td =taskService.deleteTask(task_Id);
        TaskDetails td2 = taskService.getTask(taskId);
        List<String> employeeEmail = taskService.getEmployeeEmail(employee.getEmail());
        model.addObject("td", td2);
        model.addObject("employeeEmail", employeeEmail);

        return model;
    }*/
    
    
    
    
    
    
    
    
    @RequestMapping(value = "/taskAllocated", method = RequestMethod.POST)
    public ModelAndView success(@ModelAttribute("td") TaskDetails td, @ModelAttribute("taskdetails") TaskDetails taskdetails, HttpServletRequest request) {

//        int pId = Integer.parseInt(request.getParameter("project_id"));
//        taskdetails.setProjectId(pId);
//        int mId = Integer.parseInt(request.getParameter("mgrid"));
//        taskdetails.setManagerId(mId);
////        ModelAndView mav = new ModelAndView("redirect:/showtask?project_id=" + pId + "&mgrid=" + mId + "");
//        ModelAndView mav = new ModelAndView("redirect:/showtask");
//
//        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
//        td.setStatus("Assigned");
//        taskService.addTask(td);
//
//        List<TaskDetails> listtask = taskService.getAllTask();
//        System.out.println("List of task:  " + listtask);
//        mav.addObject("task_Type", Tasktype);
//        mav.addObject("taskdetails", taskdetails);
//
//        return mav;
        int pId = taskdetails.getProjectId();
        taskdetails.setStatus("Assigned");
        taskdetails.setProjectId(pId);
        int mId = taskdetails.getManagerId();
        taskdetails.setManagerId(mId);
        System.out.println("Project ID::::    " + pId + "Manager ID::::::    " + mId);
        ModelAndView mav = new ModelAndView("success");
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
        mav.addObject("task_Type", Tasktype);
        List<TaskDetails> listtask = taskService.getAllTask();
        System.out.println("List of task:  " + listtask);
        taskService.addTask(taskdetails);
        mav.addObject("taskdetails", taskdetails);
        mav.addObject("listtask", listtask);
        return mav;

    }

    @RequestMapping(value = "/taskSubmit", method = RequestMethod.GET)
    public ModelAndView taskSubmit(@ModelAttribute("taskdetails") TaskDetails taskdetails) {
        ModelAndView mav = new ModelAndView("createtask");
        String[] Tasktype = {"Coding", "Design", "Integration", "Quality", "Testing"};
//        mav.addObject("task_Type", Tasktype);
//        int pId = Integer.parseInt(request.getParameter("project_id"));
//        List<TaskDetails> listtask = taskService.getByProjectId(pId);
        mav.addObject("taskdetails", taskdetails);
//        mav.addObject("listtask", listtask);
        return mav;
    }

}
