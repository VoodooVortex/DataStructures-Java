import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigO1Test {

    @Test
    public void testAddTwoNumbers() {
        BigO1 example = new BigO1();

        assertEquals(5, example.addTwoNumbers(2, 3));

        assertEquals(10, example.addTwoNumbers(5, 5));

        assertEquals(-3, example.addTwoNumbers(0, -3));

    }
}