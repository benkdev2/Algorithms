import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays median;

    @BeforeEach
    void setUp() {
        median = new MedianOfTwoSortedArrays();
    }

    @Test
    void testNegativeIntegers() {
        int[] array1 = new int[]{-5,-4,-3,-2,-1};
        int[] array2 = new int[]{0,1};
        double medianValue = median.medianOfTwoSortedIntegerArrays(array1, array2);
        assertEquals(-2, medianValue, "Wrong median value. " +
                "Expected -2, was " + medianValue);
    }

    @Test
    void testEvenNumberOfValues() {
        int[] array1 = new int[]{-5,-4,-3,-2};
        int[] array2 = new int[]{0,1,2,3};
        double medianValue = median.medianOfTwoSortedIntegerArrays(array1, array2);
        assertEquals(-1.0, median.medianOfTwoSortedIntegerArrays(array1, array2), "Wrong median value. " +
                "Expected -1.0, was " + medianValue);
    }

    @Test
    void testNullArray1() {
        int[] array2 = new int[]{1};
        try {
            median.medianOfTwoSortedIntegerArrays(null, array2);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException");
        }
    }

    @Test
    void testNullArray2() {
        int[] array1 = new int[]{1};
        try {
            median.medianOfTwoSortedIntegerArrays(array1, null);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException");
        }
    }

    @Test
    void testEmptyArray1() {
        int[] array1 = new int[]{};
        int[] array2 = new int[]{1};
        try {
            median.medianOfTwoSortedIntegerArrays(array1, array2);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException");
        }
    }

    @Test
    void testEmptyArray2() {
        int[] array1 = new int[]{1};
        int[] array2 = new int[]{};
        try {
            median.medianOfTwoSortedIntegerArrays(array1, array2);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException");
        }
    }
}