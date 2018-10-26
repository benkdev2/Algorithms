import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanJumpTest {

    static CanJump canJump;

    @BeforeAll
    static void init() {
        canJump = new CanJump();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void canJumpStraightForwardTest() {
        boolean expected = true;
        int[] testInput = new int[]{1,2,0,4}; //1 -> 2 -> 4
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpDecrementTest() {
        boolean expected = true;
        int[] testInput = new int[]{2,2,0,3,4}; //1 -> 2 -> 1 -> 4
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpNoPathTest() {
        boolean expected = false;
        int[] testInput = new int[]{2,2,0,0,4}; //no path
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpZeroFirstElementTest() {
        boolean expected = false;
        int[] testInput = new int[]{0,2,0,4}; //no path
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpEmptyInputTest() {
        boolean expected = false;
        int[] testInput = new int[]{}; //invalid input
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpNullInputTest() {
        boolean expected = false;
        int[] testInput = null; //invalid input
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpOneInputTest() {
        boolean expected = true;
        int[] testInput = new int[]{100}; //Can always jump to end
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpOneInputOfZeroTest() {
        boolean expected = true;
        int[] testInput = new int[]{0}; //Can always jump to end
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }

    @Test
    void canJumpBackwardInputTest() {
        boolean expected = false;
        int[] testInput = new int[]{3,2,1,0,4};
        boolean actual = canJump.canJump(testInput);
        assertEquals(expected, actual, "Expected " + expected + "and was " + actual);
    }
}