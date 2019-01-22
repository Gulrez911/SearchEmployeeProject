package com.kgate.controller;

import com.kgate.model.Employee;
import com.kgate.service.EmployeeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminAjaxController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employeelist2", method = RequestMethod.GET)
    public ModelAndView viewlist() {
        ModelAndView model = new ModelAndView("home2");

        return model;
    }

//    @RequestMapping(value = "/listEmp", method = RequestMethod.GET)
//    public @ResponseBody
//    Map<String, Object> viewEmplist() {
//        Map<String, Object> map = new HashMap<>();
//        List<Employee> list = employeeService.getAllEmployees();
//        map.put("list", list);
//        return map;
//    }
    @RequestMapping(value = "/listEmp", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> viewEmplist() {
        Map<String, Object> map = new HashMap<>();
        System.out.println("page no.............  " );
        List<Employee> list3 = employeeService.getAllEmployees();
        int pageNo = (list3.size() / 3) + 1;
        int record = 3;
        int pageId = 1;
        if (pageId == 1) {
        } else {
            pageId = (pageId - 1) * record + 1;
        }
//        List<Employee> list = employeeService.getAllEmployees();
        List<Employee> list = employeeService.getAllEmployees(1);
        map.put("list", list);
        map.put("pno", pageNo);
        return map;
    }
}
