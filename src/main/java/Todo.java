//package main.java;

/**
 * The Todo class is an extention of the Task class with a few custom
 * properties like the type.
 * 
 * @author Varun Parmar
 */
public class Todo extends Task {

    /**
     * This method is the default constructor for the Todo class.
     * 
     * @param title. Represents the title of the Todo in String format.
     */
    Todo(String title) {
        super(title);
        this.type = "[T]";
    }

}