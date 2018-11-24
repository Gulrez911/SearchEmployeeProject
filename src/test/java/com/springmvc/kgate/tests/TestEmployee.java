/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.kgate.tests;

import com.kgate.dao.EmployeeDAO;
import com.kgate.model.Employee;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author user
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
@Transactional
public class TestEmployee {

    @Autowired
    EmployeeDAO edao;

    @Test
//    @Rollback(value = false)
    public void testSearchEmployees() {
        String skill = "HTML";
        List<Employee> emps = edao.searchEmployees(skill);
        System.out.println("" + emps.size());
    }

}
