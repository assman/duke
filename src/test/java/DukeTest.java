import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class implements the unit testing code for the Duke class
 * 
 * @author Varun Parmar
 */
public class DukeTest {
    @Test
    public void dummyTest() {
        assertEquals(2, 2);
    }

    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }

    @Test
    void justAnExample() {
        System.out.println("This test method should be run");
    }
}