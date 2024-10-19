import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTimeExampleTest {

    @Test
    public void testPolynomialSum() {

        PolynomialTimeExample example = new PolynomialTimeExample();

        int[] array = {1, 2, 3};

        assertEquals(36, example.polynomialSum(array));

    }
}