package com.kgate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DateController {

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public String view(ModelMap map) {
      
        String msg = "Hello World";
        map.addAttribute("hello", msg);
        return "date";
    }
}
