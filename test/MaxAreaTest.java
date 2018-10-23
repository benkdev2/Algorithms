import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAreaTest {

    MaxArea maxArea;

    @BeforeEach
    void setUp() {
        maxArea = new MaxArea();
    }

    @Test
    void maxAreaOddTest() {
        int[] height = new int[]{2,3,8};
        int actual = maxArea.maxArea(height);
        int expected = 4;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }

    @Test
    void maxAreaTwoTest() {
        int[] height = new int[]{2,3};
        int actual = maxArea.maxArea(height);
        int expected = 2;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }

    @Test
    void maxAreaOneTest() {
        int[] height = new int[]{3};
        int actual = maxArea.maxArea(height);
        int expected = 3;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }

    @Test
    void maxAreaNullTest() {
        int[] height = null;
        int actual = maxArea.maxArea(height);
        int expected = 0;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }

    @Test
    void maxAreaZeroesTest() {
        int[] height = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int actual = maxArea.maxArea(height);
        int expected = 0;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }

    @Test
    void maxAreaFromRight() {
        int[] height = new int[]{4,7,2,3,1,8,8};
        int actual = maxArea.maxArea(height);
        int expected = 35;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }

    @Test
    void maxAreaFromLeft() {
        int[] height = new int[]{8,7,2,3,1,6,1};
        int actual = maxArea.maxArea(height);
        int expected = 30;
        assertEquals(actual, expected, "Expected " + expected + " but was " + actual);
    }
}