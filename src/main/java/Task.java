package main.java;
import java.io.*;

/**
 * The Task class serves as the parent class that forms the skeleton for a generic Todo
 * 
 * @author Varun Parmar
 */

public class Task implements Serializable {
    protected String title = null;
    protected String description = null;
    protected boolean done = false;
    protected String type = null;
    protected String statusIcon = null;

  /**
   * This is the constructor of the class that initializes the title and status icon as not done by default.
   * @param taskTitle.
   * @return Nothing.
   */
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

    /**
     * This method returns the String representation of the Task.
     * @return String This returns the string representation of the Task
     */
    public String toString() {
        return type + statusIcon + title;
    }

}