package com.kgate.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
 

@Entity
@Table(name = "Project_Details")
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer project_id;

    @Column
    private String project_Name;
    @Column
    private String project_desc;

    @Column
   
//    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date pstart_Date;
    @Column
//    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date pEnd_Date;

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getProject_Name() {
        return project_Name;
    }

    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public Date getPstart_Date() {
        return pstart_Date;
    }

    public void setPstart_Date(Date pstart_Date) {
        this.pstart_Date = pstart_Date;
    }

    public Date getpEnd_Date() {
        return pEnd_Date;
    }

    public void setpEnd_Date(Date pEnd_Date) {
        this.pEnd_Date = pEnd_Date;
    }

    @Override
    public String toString() {
        return "ProjectDetails [project_id=" + project_id + ", project_Name=" + project_Name + ", project_desc="
                + project_desc + ", pstart_Date=" + pstart_Date + ", pEnd_Date=" + pEnd_Date + "]";
    }

}
