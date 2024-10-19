import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        assertAll(
                () -> assertEquals(4, Calculator.add(2,2)),
                () -> assertEquals(5, Calculator.add(2, 3))
        );
    }

    @Test
    void multiply() {
        assertAll(
                () -> assertEquals(4, Calculator.multiply(2,2)),
                () -> assertEquals(6, Calculator.multiply(2, 3))
        );
    }

    @Test
    void minus() {
        assertAll(
                () -> assertEquals(2, Calculator.minus(4,2)),
                () -> assertEquals(3, Calculator.minus(6, 3))
        );
    }

    @Test
    void divide() {
        assertAll(
                () -> assertEquals(1, Calculator.divide(5,5)),
                () -> assertEquals(2, Calculator.divide(6, 3))
        );
    }
}