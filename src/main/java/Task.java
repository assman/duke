package main.java;
import java.io.*;

public class Task implements Serializable {
    protected String title = null;
    protected String description = null;
    protected boolean done = false;
    protected String type = null;
    protected String statusIcon = null;

    Task(String taskTitle) {
        title = taskTitle;
        statusIcon = "[\u2718]";
      }

    public String getTitle(){
        return title;
    }

    public void setTitle(String todoTitle){
        title = todoTitle;
    }

    public boolean getDone(){
        return done;
    }

    public String getStatusIcon() {
        return statusIcon;
    }

    public void setDone(boolean d){
        done = d;
        statusIcon = "[\u2713]";
    }

    public String getTaskType(){
        return type;
    }

    public String toString() {
        return type + statusIcon + title;
    }

}