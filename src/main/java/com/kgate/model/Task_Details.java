package com.kgate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Task_Details")
public class Task_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int task_id;

    @Column
    private String task_Type;
    @Column
    private String task_Name;
    @Column
    private String status;
    @Column
    private Date tStart_Time;
    @Column
    private Date tEnd_Time;
    @Column
    private String Emp_Email;
    @Column
    private Date tSub_Date;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_Type() {
        return task_Type;
    }

    public void setTask_Type(String task_Type) {
        this.task_Type = task_Type;
    }

    public String getTask_Name() {
        return task_Name;
    }

    public void setTask_Name(String task_Name) {
        this.task_Name = task_Name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date gettStart_Time() {
        return tStart_Time;
    }

    public void settStart_Time(Date tStart_Time) {
        this.tStart_Time = tStart_Time;
    }

    public Date gettEnd_Time() {
        return tEnd_Time;
    }

    public void settEnd_Time(Date tEnd_Time) {
        this.tEnd_Time = tEnd_Time;
    }

    public String getEmp_Email() {
        return Emp_Email;
    }

    public void setEmp_Email(String emp_Email) {
        Emp_Email = emp_Email;
    }

    public Date gettSub_Date() {
        return tSub_Date;
    }

    public void settSub_Date(Date tSub_Date) {
        this.tSub_Date = tSub_Date;
    }

    @Override
    public String toString() {
        return "Task_Details [task_id=" + task_id + ", task_Type=" + task_Type + ", task_Name=" + task_Name
                + ", status=" + status + ", tStart_Time=" + tStart_Time + ", tEnd_Time=" + tEnd_Time + ", Emp_Email="
                + Emp_Email + ", tSub_Date=" + tSub_Date + "]";
    }

}
