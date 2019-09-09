package main.java;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    protected LocalDateTime at;

    Event(String title, LocalDateTime when){
        super(title);
        this.type = "[E]";
        this.at = when;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return super.toString() + " (at: " + at.format(formatter) + ")";
    }

}