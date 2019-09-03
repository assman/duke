package main.java;

import java.util.*;
import java.io.*;

public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void deleteTask(Integer index) {
        this.taskList.remove(index);
    }

    public Integer size() {
        return this.taskList.size();
    }

    public Task get(Integer index) {
        return this.taskList.get(index);
    }

    public ArrayList<Task> getlist() {
        return this.taskList;
    }

    public void setlist(ArrayList<Task> tList) {
        this.taskList = tList;
    }

    public void remove(Integer index){
        this.taskList.remove(index);
    }
}