import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ArrayList arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ArrayList(5);
    }

    @Test
    void testAddAndGet() {
        arrayList.add("first");
        arrayList.add("second");
        assertEquals("first", arrayList.get(0));
        assertEquals("second", arrayList.get(1));
    }

    @Test
    void testAddAtSpecificIndex() {
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add(1, "middle");
        assertEquals("first", arrayList.get(0));
        assertEquals("middle", arrayList.get(1));
        assertEquals("second", arrayList.get(2));
    }

    @Test
    void testSet() {
        arrayList.add("first");
        arrayList.add("second");
        arrayList.set(0, "newFirst");
        assertEquals("newFirst", arrayList.get(0));
    }

    @Test
    void testRemove() {
        arrayList.add("first");
        arrayList.add("second");
        arrayList.remove("first");
        assertFalse(arrayList.find("first"));
        assertEquals(1, arrayList.size());
        assertEquals("second", arrayList.get(0));
    }

    @Test
    void testFind() {
        arrayList.add("first");
        arrayList.add("second");
        assertTrue(arrayList.find("first"));
        assertFalse(arrayList.find("third"));
    }

    @Test
    void testIndexOf() {
        arrayList.add("first");
        arrayList.add("second");
        assertEquals(0, arrayList.indexOf("first"));
        assertEquals(1, arrayList.indexOf("second"));
        assertEquals(-1, arrayList.indexOf("third"));
    }

    @Test
    void testShow() {
        arrayList.add("first");
        arrayList.add("second");
        // This test is a bit tricky since show prints to console
        // You might need to manually verify the console output
        arrayList.show();
    }

    @Test
    void testSize() {
        assertEquals(0, arrayList.size());
        arrayList.add("first");
        assertEquals(1, arrayList.size());
    }

    @Test
    void testMaxSize() {
        assertEquals(5, arrayList.maxSize());
    }

    @Test
    void testIsEmpty() {
        assertTrue(arrayList.isEmpty());
        arrayList.add("first");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void testIsFull() {
        assertFalse(arrayList.isFull());
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");
        arrayList.add("fourth");
        arrayList.add("fifth");
        assertTrue(arrayList.isFull());
    }

    @Test
    void testAddThrowsExceptionWhenFull() {
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");
        arrayList.add("fourth");
        arrayList.add("fifth");
        assertThrows(RuntimeException.class, () -> arrayList.add("sixth"));
    }

    @Test
    void testGetThrowsExceptionWhenOutOfBounds() {
        arrayList.add("first");
        assertThrows(RuntimeException.class, () -> arrayList.get(1));
    }

    @Test
    void testSetThrowsExceptionWhenOutOfBounds() {
        arrayList.add("first");
        assertThrows(RuntimeException.class, () -> arrayList.set(1, "newFirst"));
    }

    @Test
    void testAddAtSpecificIndexThrowsExceptionWhenOutOfBounds() {
        assertThrows(RuntimeException.class, () -> arrayList.add(1, "first"));
    }

    // New tests for handling integer values
    @Test
    void testAddAndGetIntegers() {
        arrayList.add(10);
        arrayList.add(20);
        assertEquals(10, arrayList.get(0));
        assertEquals(20, arrayList.get(1));
    }

    @Test
    void testAddAtSpecificIndexIntegers() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(1, 15);
        assertEquals(10, arrayList.get(0));
        assertEquals(15, arrayList.get(1));
        assertEquals(20, arrayList.get(2));
    }

    @Test
    void testSetIntegers() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.set(0, 30);
        assertEquals(30, arrayList.get(0));
    }

    @Test
    void testRemoveIntegers() {
        arrayList.add(10);
        arrayList.add(20);
        arrayList.remove(10);
        assertFalse(arrayList.find(10));
        assertEquals(1, arrayList.size());
        assertEquals(20, arrayList.get(0));
    }

    @Test
    void testFindIntegers() {
        arrayList.add(10);
        arrayList.add(20);
        assertTrue(arrayList.find(10));
        assertFalse(arrayList.find(30));
    }

    @Test
    void testIndexOfIntegers() {
        arrayList.add(10);
        arrayList.add(20);
        assertEquals(0, arrayList.indexOf(10));
        assertEquals(1, arrayList.indexOf(20));
        assertEquals(-1, arrayList.indexOf(30));
    }
}