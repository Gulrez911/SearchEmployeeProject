package com.kgate.controller;

import com.kgate.dao.SkillDao;
import com.kgate.model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

//@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSkill {

    @Autowired
    private SkillDao dao;

    @Test
    @Transactional
    @Rollback(true)
    public void test() {
        int skill_id = 1;
        Skill skill = new Skill();
        skill = dao.getSkill(skill_id);
        System.out.println("Skill Name:    " + skill);
    }
    
//    public void hello(){
//        System.out.println("Test :");
//    }
}
