
//package main.java;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Deadline class is an extention of the Task class with a few custom
 * properties like the type and the deadline date/time
 * 
 * @author Varun Parmar
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * This method is the default constructor for the Deadline class.
     * 
     * @param title.    Represents the title of the Deadline in String format.
     * @param deadline. Represents the Date/Time deadline of the Deadline in the
     *                  form of a LocalDateTime object.
     */
    Deadline(String title, LocalDateTime deadline) {
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