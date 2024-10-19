import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigO_log_nTest {

    @Test
    public void testBinarySearch() {

        BigO_log_n example = new BigO_log_n();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertEquals(4, example.binarySearch(array, 5));

        assertEquals(-1, example.binarySearch(array, 11));

    }


}