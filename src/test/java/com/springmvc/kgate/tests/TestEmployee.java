/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.kgate.tests;
 
import com.kgate.dao.EmployeeDAO;
import com.kgate.dao.SkillDao;
import com.kgate.model.Skill;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author user
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
//@ContextConfiguration({"file:WEB-INF/spring-servlet.xml"})

@Transactional
public class TestEmployee {

    @Autowired
    EmployeeDAO edao;

    @Autowired
    SkillDao skillDao;

   
//    @Rollback(value = false)
    
//    @Test
//    @Rollback(value = false)
//    public void getEmployeeSkill(){
//        int id = 34;
////        List<Skill> skill = skillDao.getEmployeeSkill(id);
////        System.out.println("Skill List:    "+skill);
//    }
//    @Test
//    @Rollback(value = false)
//    public void getAllSkills() {
//
//        List<Skill> li = skillDao.getAllSkill();
//        System.out.println("List of Skill:  " + li.size());
//       
//    }

}
