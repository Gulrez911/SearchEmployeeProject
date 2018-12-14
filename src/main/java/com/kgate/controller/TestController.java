package com.kgate.controller;

import com.kgate.model.Skill;
import com.kgate.service.SkillService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController
{

//     @RequestMapping(value = "/test")
//     public ModelAndView viewSkill(){
//         return new ModelAndView("test");
//     }
    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Skill skill = new Skill();
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
        model.addObject("skill", skill);
        model.setViewName("test");
        return model;
    }

    @RequestMapping(value = "/saveTest", method = RequestMethod.POST)
    public ModelAndView saveSkill(@ModelAttribute Skill skill) {
        if (skill.getSkill_Id() == 0) { // if skill id is 0 then creating the
//            // skill other updating the skill
            skillService.addSkill(skill);
        } else {
            skillService.updateSkill(skill);

        }
 
        return new ModelAndView("redirect:/test");
    }
    
    @RequestMapping(value = "/deleteTest", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int skill_Id = Integer.parseInt(request.getParameter("skill_Id"));
		skillService.deleteSkill(skill_Id);
              //  employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/test");
	}
       
        @RequestMapping(value = "/editTest", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int skill_Id = Integer.parseInt(request.getParameter("skill_Id"));
		Skill skill = skillService.getSkill(skill_Id);
              //  Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("test");
		model.addObject("skill", skill);

		return model;
	}
    
}
