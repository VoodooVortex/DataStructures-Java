import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigO_NTest {

    @Test
    public void testSumArray() {

        BigO_N example = new BigO_N();

        int[] array = {1, 2, 3, 4, 5};

        assertEquals(15, example.sumArray(array));

    }
}