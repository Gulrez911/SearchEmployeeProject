/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.kgate.tests;
import org.springframework.beans.factory.annotation.Autowired;
import com.kgate.dao.EmployeeDAO;
import com.kgate.dao.SkillDao;
import com.kgate.model.Skill;
import com.kgate.service.EmployeeService;
import com.kgate.service.SkillService;
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
@ContextConfiguration({"classpath*:spring-servlet.xml"})
public class TestEmployee {

    @Autowired
    private EmployeeService employeeService;


	@Autowired
	private SkillService skillService;

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
    
    @Test
    @Rollback(true)
    public void test() {
        int skill_id = 1;
        Skill skill = new Skill();
        skill = skillService.getSkill(skill_id);
        System.out.println("Skill Name:    " + skill);
    }

}
