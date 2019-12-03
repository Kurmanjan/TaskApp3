package com.geektech.taskapp;

import java.io.Serializable;

public class Task implements Serializable {

    private String title;
    private String desk;

    public Task(String title,String desk) {
        this.title = title;
        this.desk = desk;
    }

    public  Task() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }
}



