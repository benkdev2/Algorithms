import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    int target;
    int parts[];
    TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    void twoSumNoSolution() {
        target = 10;
        parts = new int[]{-2, 0, 5, 4, -4, 7};
        int[] expected = new int[]{};
        int[] result = twoSum.twoSum(parts, target);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    void twoSumNegatives() {
        target = -6;
        parts = new int[]{-2, 0, 5, 4, -4, 7};
        int[] expected = new int[]{0,4};
        int[] result = twoSum.twoSum(parts, target);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    void twoSumPositives() {
        target = 7;
        parts = new int[]{-2, 1, 5, 4, -4, 6};
        int[] expected = new int[]{1,5};
        int[] result = twoSum.twoSum(parts, target);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    void twoSumWithZero() {
        target = 3;
        parts = new int[]{-2, 0, 6, 3, -4, 2};
        int[] expected = new int[]{1,3};
        int[] result = twoSum.twoSum(parts, target);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    void testNullInput() {
        target = 7;
        parts = null;
        int[] expected = new int[]{};
        int[] result = twoSum.twoSum(parts, target);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    void testEmptyInput() {
        target = 7;
        parts = new int[]{};
        int[] expected = new int[]{};
        int[] result = twoSum.twoSum(parts, target);
        Assert.assertArrayEquals(expected, result);
    }
}