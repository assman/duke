import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class implements the unit testing code for the Todo class
 * 
 * @author Varun Parmar
 */
public class TodoTest {
    Todo todo = new Todo("test todo");

    @Test
    public void testTodoCreation() {
        String title = todo.getTitle();
        assertEquals(title, "test todo");
    }

    @Test
    public void testTaskType() {
        assertEquals(todo.getTaskType(), "[T]");
    }

}