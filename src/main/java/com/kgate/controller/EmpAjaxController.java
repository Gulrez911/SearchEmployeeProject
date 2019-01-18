package com.kgate.controller;

import com.kgate.model.Skill;
import com.kgate.service.SkillService;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpAjaxController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "/testAjax")
    public ModelAndView viewPage(@ModelAttribute Skill skill) {
        ModelAndView model = new ModelAndView("test");
        model.addObject("listSkill", skillService.getAllSkills());
        return model;
    }

    @RequestMapping(value = "/SaveSkillAjax", method = RequestMethod.POST)
    public @ResponseBody
    Skill postEmployeeData(@RequestBody Skill skill) {
        ModelAndView model = new ModelAndView();
        System.out.println("test..............." + skill);
        skillService.addSkill(skill);
//        List<Skill> listSkill = skillService.getAllSkills();
//        model.addObject("listSkill", listSkill);
        return skill;
    }

    @RequestMapping(value = "/deleteSkillAjax", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Skill deleteSkill(@RequestBody int id) {
        System.out.println("skill ID;;;;;" + id);
        Skill skill = new Skill();
        skillService.deleteSkill(id);
        ModelAndView model = new ModelAndView();
        List<Skill> listSkill = skillService.getAllSkills();
        model.addObject("listSkill", listSkill);
        return skill;
    }

    @RequestMapping(value = "/getAllSkillsAjax", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Skill getAllSkillsAjax() {
        ModelAndView model = new ModelAndView();
        model.addObject("listSkill", skillService.getAllSkills());
        Skill skill = new Skill();
        return skill;
    }

    @RequestMapping(value = "/save2", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, Object> getSaved(Skill skill) {
        Map<String, Object> map = new HashMap<String, Object>();
        skillService.addSkill(skill);

        return map;
    }

    @RequestMapping(value = "/list2", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getAll(Skill skill) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Skill> list = skillService.getAllSkills();

        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");

        }

        return map;
    }

    @RequestMapping(value = "/delete2", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> delete(Skill skill) {
        Map<String, Object> map = new HashMap<String, Object>();

        System.out.println("delete skill...........");
        skillService.deleteSkill(skill.getSkill_Id());
        return map;
    }

}
