import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    @Test
    public void dummyTest(){
        assertEquals(2, 2);
    }
    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }
}