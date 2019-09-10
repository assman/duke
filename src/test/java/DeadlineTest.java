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

    

}