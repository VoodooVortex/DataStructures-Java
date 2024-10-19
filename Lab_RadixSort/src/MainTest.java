import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class MainTest {
    @Test
    void case0(){
        String input = "7" + System.lineSeparator() +
                "321" + System.lineSeparator() +
                "142" + System.lineSeparator() +
                "5" + System.lineSeparator() +
                "81" + System.lineSeparator() +
                "19" + System.lineSeparator() +
                "391"  + System.lineSeparator() +
                "25";
        String expectedOutput = "Step 1: 321, 81, 391, 142, 5, 25, 19" + System.lineSeparator() +
                "Step 2: 5, 19, 321, 25, 142, 81, 391" + System.lineSeparator() +
                "Step 3: 5, 19, 25, 81, 142, 321, 391" + System.lineSeparator() +
                "Result => 5, 19, 25, 81, 142, 321, 391" + System.lineSeparator();

        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        try {
            ByteArrayInputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(mockInputStream);

            ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutputStream));

            Main.main(null);

            String actualOutput = mockOutputStream.toString();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }

    @Test
    void case1(){
        String input = "5" + System.lineSeparator() + "5" + System.lineSeparator() + "4" + System.lineSeparator() + "3" + System.lineSeparator() + "2" + System.lineSeparator() + "1";
        String expectedOutput = "Step 1: 1, 2, 3, 4, 5" + System.lineSeparator() + "Result => 1, 2, 3, 4, 5" + System.lineSeparator();

        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        try {
            ByteArrayInputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(mockInputStream);

            ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutputStream));

            Main.main(null);

            String actualOutput = mockOutputStream.toString();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }

    @Test
    void case2(){
        String input = "5" + System.lineSeparator() + "123" + System.lineSeparator() + "10" + System.lineSeparator() + "1" + System.lineSeparator() + "5" + System.lineSeparator() + "9";
        String expectedOutput = "Step 1: 10, 1, 123, 5, 9" + System.lineSeparator() +
                "Step 2: 1, 5, 9, 10, 123" + System.lineSeparator() +
                "Step 3: 1, 5, 9, 10, 123" + System.lineSeparator() +
                "Result => 1, 5, 9, 10, 123" + System.lineSeparator();

        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        try {
            ByteArrayInputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(mockInputStream);

            ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutputStream));

            Main.main(null);

            String actualOutput = mockOutputStream.toString();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }

    @Test
    void case3(){
        String input = "5" + System.lineSeparator() + "123" + System.lineSeparator() + "321" + System.lineSeparator() + "100" + System.lineSeparator() + "550" + System.lineSeparator() + "120";
        String expectedOutput = "Step 1: 100, 550, 120, 321, 123" + System.lineSeparator() +
                "Step 2: 100, 120, 321, 123, 550" + System.lineSeparator() +
                "Step 3: 100, 120, 123, 321, 550" + System.lineSeparator() +
                "Result => 100, 120, 123, 321, 550" + System.lineSeparator();

        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        try {
            ByteArrayInputStream mockInputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(mockInputStream);

            ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockOutputStream));

            Main.main(null);

            String actualOutput = mockOutputStream.toString();
            assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }

}