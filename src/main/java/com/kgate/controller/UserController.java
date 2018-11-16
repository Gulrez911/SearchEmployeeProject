package com.kgate.controller;

import com.kgate.model.User;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
 //@RequestMapping(value = ("/"))
public class UserController {
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "login";
    }
 
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("loginModel") @Valid User user) {
   //     System.out.println("in submit" + user);
        String password = user.getPassword();
        if (password != null && password.equals("admin")) {
            modelMap.put("userInfo", user.getUserName());
            return "success";
        } else {
            modelMap.put("error", "Invalid UserName / Password");
            return "login";
        }

    }
}
