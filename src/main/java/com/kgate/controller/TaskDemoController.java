package com.kgate.controller;

import com.kgate.model.Employee;
import com.kgate.model.TaskDetails;
import com.kgate.service.TaskService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskDemoController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/allotTask", method = RequestMethod.GET)
    public ModelAndView allotTask() {
        ModelAndView model = new ModelAndView("AllocateTask");
        TaskDetails td = new TaskDetails();
        model.addObject("td", td);
        List<String> employeeEmail = taskService.getEmployeeEmail("");

        System.out.println("Lis of Emloyee Email::: " + employeeEmail);
//        List<String> sk = new ArrayList<>();
//
//        Employee employee = new Employee();
//        for (int i = 0; i < employeeEmail.size(); i++) {
//            Object o = employeeEmail.get(i);
//            String s = (String) o;
//            sk.add(s);
//        }
//        employee.setEmail(sk);
        return model;

    }

}
