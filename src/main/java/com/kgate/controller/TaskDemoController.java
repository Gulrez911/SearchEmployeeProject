package com.kgate.controller;

import com.kgate.model.TaskDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskDemoController {

    @RequestMapping(value = "/allotTask", method = RequestMethod.GET)
    public ModelAndView allotTask() {
        ModelAndView model = new ModelAndView("AllocateTask");
        TaskDetails td = new TaskDetails();
        model.addObject("td", td);
        return model;

    }

}
