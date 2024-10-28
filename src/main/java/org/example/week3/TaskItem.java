package org.example.week3;

public class TaskItem{
    private int id;
    private String description;
    private Status status;

    public TaskItem(int id, String description, Status status){
        this.id = id;
        this.description = description;
        this.status = status;
    }
    public int getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public Status getStatus(){
        return status;
    }

}
