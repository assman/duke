package main.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The event class is an extention of the Task class with a few custom
 * properties like the date and time of the event.
 * 
 * @author Varun Parmar
 */
public class Event extends Task {
    protected LocalDateTime at;

    /**
     * This method is the default constructor for the Event class.
     * 
     * @param title. Represents the title of the event in String format.
     * @param when.  Represents the Date/Time of the event in the form of a
     *               LocalDateTime object.
     */
    Event(String title, LocalDateTime when) {
        super(title);
        this.type = "[E]";
        this.at = when;
    }

    /**
     * This method overrides the toString method of the parent class.
     * 
     * @return String. Returns the string representation of the event with the date
     *         and time appended to its name and type
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return super.toString() + " (at: " + at.format(formatter) + ")";
    }

}