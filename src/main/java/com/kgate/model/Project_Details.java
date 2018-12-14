package com.kgate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project_Details")
public class Project_Details {

	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int project_id;
	  
	  @Column
	  private String project_Name;
	  @Column
	  private String project_desc;
	  @Column
	  private Date pstart_Time;
	  @Column
	  private Date pEnd_Time;
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
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
	public Date getPstart_Time() {
		return pstart_Time;
	}
	public void setPstart_Time(Date pstart_Time) {
		this.pstart_Time = pstart_Time;
	}
	public Date getpEnd_Time() {
		return pEnd_Time;
	}
	public void setpEnd_Time(Date pEnd_Time) {
		this.pEnd_Time = pEnd_Time;
	}
	@Override
	public String toString() {
		return "Project_Details [project_id=" + project_id + ", project_Name=" + project_Name + ", project_desc="
				+ project_desc + ", pstart_Time=" + pstart_Time + ", pEnd_Time=" + pEnd_Time + "]";
	}
	

	  
	  
	
	
	
}
