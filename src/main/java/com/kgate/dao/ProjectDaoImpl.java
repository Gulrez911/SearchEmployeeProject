package com.kgate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgate.model.ProjectDetails;
import com.kgate.model.ProjectReportDTO;

import com.kgate.model.TaskDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProject(ProjectDetails project) {
        Session s = this.sessionFactory.getCurrentSession();
        s.saveOrUpdate(project);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProjectDetails> dispalyProjects() {
        return sessionFactory.getCurrentSession().createQuery("from ProjectDetails")
                .list();
    }

    @Override
    public int getManagerid(String email) {
        Query q = sessionFactory.getCurrentSession().createQuery(" select id from  Employee where email='" + email + "'");

        /*	 int id=Integer.parseInt(s);
		 return id;*/
        int id = (int) q.uniqueResult();
        return id;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TaskDTO> displayAllStatus(int id) {

        String query = "select a.name AS 'Employee Name' ,b.name AS 'Manager Name', task_details.task_Name, task_details.task_Type,task_details.tStart_Time,task_details.tEnd_Time, task_details.taskStatus from employee123 a, employee123 b cross join task_details where a.category = 'employee' AND a.managerId = b.id AND b.category ='Manager' AND task_details.Emp_Email=a.email AND task_details.projectId='" + id + "'";

        List<TaskDTO> listtsk = new ArrayList<TaskDTO>();
        List<Object> data = sessionFactory.getCurrentSession().createSQLQuery(query).list();

        for (Object d : data) {

            Object arr[] = (Object[]) d;
            String st, st1, st2, st3, st4, st5, st6, st8;

            TaskDTO tdto = new TaskDTO();

            st = (String) arr[0];
            st1 = (String) arr[1];
            st2 = (String) arr[2];
            st3 = (String) arr[3];
            st4 = arr[4].toString();
            st5 = arr[5].toString();
            st6 = (String) arr[6];

            tdto.setEmp_name(st);
            tdto.setName(st1);
            tdto.setTask_Name(st2);
            tdto.setTask_Type(st3);
            tdto.settStartDate(st4);
            tdto.settEndDate(st5);
            tdto.setStatus(st6);

            listtsk.add(tdto);
        }

        return listtsk;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProjectDetails> getProjectByEmail(String email) {

        return sessionFactory.getCurrentSession().createQuery("from ProjectDetails where manageremail='" + email + "'")
                .list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProjectReportDTO> listProjectReport() {
        List<ProjectReportDTO> listproject = new ArrayList<>();
//        listproject = sessionFactory.getCurrentSession().createSQLQuery("select project_details.project_Name, project_details.pstart_Date, project_details.pEnd_Date from project_details").list();
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Object> li = sessionFactory.getCurrentSession().createSQLQuery("select project_details.project_Name, project_details.pstart_Date, project_details.pEnd_Date, project_details.project_id  from project_details").list();

        List<Object> li2 = sessionFactory.getCurrentSession().createSQLQuery("select task_details.task_id, task_details.projectId, task_details.tStart_Time,task_details.tEnd_Time, task_details.tSub_Date from task_details").list();
        System.out.println("Task Details::::tets" + li2);
        System.out.println("");
        String com, var;
        int i, j, k;
        for (Object ob : li) {
            Object arr[] = (Object[]) ob;
            String s1, s2, s3, s4;
            s1 = arr[0].toString();
            s2 = arr[1].toString();
            s3 = arr[2].toString();
            i = (int) arr[3];
            System.out.println("Id:" + i);
            System.out.println("start Date::" + s2);
            System.out.println("start Date::" + s3);
            float daysBetween = 0;
            int count = 0;
            float daysBetween2 = 0;
            float daysBetween3 = 0;
            float daysBetween4 = 0;
            float daysBetween5 = 0;
            for (Object ob2 : li2) {
                String ss1, ss2, ss4;
                String ss3 = null;
                Object arr2[] = (Object[]) ob2;
//                k=(int)arr2
                j = (int) arr2[1];
                ss1 = arr2[2].toString();
                ss2 = arr2[3].toString();
                try {

                    ss3 = arr2[4].toString();
                } catch (NullPointerException ep) {
                    System.out.println("Exception:::: " + ep);

                }

                System.out.println("Id2:" + j);

                if (i == j) {
                    if (ss3 == null || ss3.isEmpty()) {
                        ss4 = java.time.LocalDate.now().toString();
                        try {
                            Date dateBefore2 = myFormat.parse(ss4);
                            System.out.println("dateBefore2::::   " + dateBefore2);
                            Date dateAfter2 = myFormat.parse(ss2);
                            System.out.println("DateAfter:::::   " + dateAfter2);
                            Date dateStart = myFormat.parse(ss1);
                            long difference2 = dateBefore2.getTime() - dateAfter2.getTime();
                            long difference3 = dateAfter2.getTime() - dateStart.getTime();
                            long difference4 = difference2 + difference3;
                            System.out.println("Difference:::::   " + difference2);
                            daysBetween3 = (difference2 / (1000 * 60 * 60 * 24));
                            daysBetween4 = (difference3 / (1000 * 60 * 60 * 24));
                            System.out.println("Days:::" + daysBetween3);
                            daysBetween2 = daysBetween2 + daysBetween3 + daysBetween4;
                        } catch (ParseException ex) {
                            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        System.out.println("Current Date:" + ss4);
                    } else {

                        try {
                            Date dateBefore2 = myFormat.parse(ss3);
                            System.out.println("dateBefore2::::   " + dateBefore2);
                            Date dateAfter2 = myFormat.parse(ss2);
                            System.out.println("DateAfter:::::   " + dateAfter2);
                            Date dateStart = myFormat.parse(ss1);
                            System.out.println("Start Date::: " + dateStart);
                            long difference2 = dateBefore2.getTime() - dateAfter2.getTime();
                            long difference3 = dateAfter2.getTime() - dateStart.getTime();
                            long difference4 = difference2 + difference3;
                            System.out.println("Difference:::::   " + difference2);
                            daysBetween3 = (difference2 / (1000 * 60 * 60 * 24));
                            daysBetween4 = (difference3 / (1000 * 60 * 60 * 24));
                            System.out.println("Days:::" + daysBetween3);
                            daysBetween2 = daysBetween2 + daysBetween3 + daysBetween4;
                            System.out.println("daysbetween2:::" + daysBetween2);
                        } catch (ParseException ex) {
                            Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
//            daysBetween2 = daysBetween2 + daysBetween3;
            int days = (int) daysBetween2;
            String s5 = Integer.toString(days);
            System.out.println("Days Between2::::   " + s5);
            try {
                Date dateBefore = myFormat.parse(s2);
                System.out.println("dateBefore::::   " + dateBefore);
                Date dateAfter = myFormat.parse(s3);
                System.out.println("DateAfter:::::   " + dateAfter);
                long difference = dateAfter.getTime() - dateBefore.getTime();
                System.out.println("Difference:::::   " + difference);
                daysBetween = (difference / (1000 * 60 * 60 * 24));
                System.out.println("Days:::::    " + daysBetween);

            } catch (ParseException ex) {
                Logger.getLogger(ProjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            int days3 = (int) daysBetween;
            s4 = Integer.toString(days3);
            daysBetween4 = daysBetween2 - daysBetween;
            int days2 = (int) daysBetween4;
            String s6 = Integer.toString(days2);
            ProjectReportDTO dTO = new ProjectReportDTO();
            dTO.setProject_name(s1);
            dTO.setpStartDate(s2);
            dTO.setpEndDate(s3);
            dTO.setExpectDate(s4);
            dTO.setCompleteTime(s5);
            dTO.setVariationTime(s6);
            System.out.println("Name:     " + s1);
            System.out.println("Start:     " + s2);
            System.out.println("End:     " + s3);
            listproject.add(dTO);
        }
//        ProjectReportDTO dt1 = new ProjectReportDTO();
//        dt1.setProject_name("This is Test Project::::");
//        listproject.add(dt1);

        return listproject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String displayProjectName(int id) {
        String query = "select project_Name from ProjectDetails where project_id='" + id + "'";
        Query query2 = sessionFactory.getCurrentSession().createQuery(query);
        String name = (String) query2.uniqueResult();
        return name;
    }

}
