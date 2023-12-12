package com.oriana.aplicacionori.Model;

public class ToDoModel {
    private int id, status;
    private String task;

    public ToDoModel(int status, String task) {
        this.status = status;
        this.task = task;
    }

    public ToDoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}

