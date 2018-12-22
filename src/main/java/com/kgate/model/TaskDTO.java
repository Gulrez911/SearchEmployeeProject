package com.kgate.model;

public class TaskDTO {

    String project_Name;
    String task_Type;
    String task_Name;
    String name;
    String tStartDate;
    String tEndDate;
    String status;
    int id;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String gettStartDate() {
        return tStartDate;
    }

    public void settStartDate(String tStartDate) {
        this.tStartDate = tStartDate;
    }

    public String gettEndDate() {
        return tEndDate;
    }

    public void settEndDate(String tEndDate) {
        this.tEndDate = tEndDate;
    }

    public String getProject_Name() {
        return project_Name;
    }

    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
