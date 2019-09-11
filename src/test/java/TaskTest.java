
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class implements the unit testing code for the Task class
 * 
 * @author Varun Parmar
 */
public class TaskTest {
    // @Test
    // public void dummyTest() {
    // assertEquals(2, 2);
    // }

    // @Test
    // public void testAdd() {
    // assertEquals(42, Integer.sum(19, 23));
    // }

    Task task = new Task("test task");

    @Test
    public void testTaskCreation() {
        String title = task.getTitle();
        assertEquals(title, "test task");
    }

    @Test
    public void testMarkTaskAsDone() {
        task.setDone(true);
        assertEquals(task.getDone(), true);
    }

}