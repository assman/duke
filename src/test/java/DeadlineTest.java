import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class implements the unit testing code for the Deadline class
 * 
 * @author Varun Parmar
 */
public class DeadlineTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse("09-06-2019 20:30", formatter);
    Deadline deadline = new Deadline("test deadline", dateTime);

    /**
     * This method tests wether the Deadline class creates a deadline object as
     * specified.
     */
    @Test
    public void testDeadlineCreation() {
        String title = deadline.getTitle();
        assertEquals(title, "test deadline");
        assertEquals(deadline.by, dateTime);
    }

    /**
     * This method verifies the type of the task.
     */
    @Test
    public void testTaskType() {
        assertEquals(deadline.getTaskType(), "[D]");
    }

}