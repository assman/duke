package main.java;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDateTime by;

    Deadline(String title, LocalDateTime deadline){
        super(title);
        this.type = "[D]";
        this.by = deadline;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return super.toString() + " (by: " + by.format(formatter) + ")";
    }

}