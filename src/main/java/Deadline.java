package main.java;

public class Deadline extends Task{
    protected String by;

    Deadline(String title, String deadline){
        super(title);
        this.type = "[D]";
        this.by = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }

}