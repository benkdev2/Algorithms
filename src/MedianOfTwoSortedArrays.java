import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    //Takes two sorted arrays, and returns a double representing the median of their values
    public double medianOfTwoSortedIntegerArrays(int[] array1, int[] array2) throws IllegalArgumentException {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException();
        }
        int array1Index = 0;
        int array2Index = 0;
        int count = 0; //for readability (we could use the above indices instead)
        boolean hasEvenNumberOfValues = false;
        if ((array1.length + array2.length) % 2 == 0) {
            hasEvenNumberOfValues = true;
        }
        double median = 0;
        int medianLocation = (array1.length + array2.length) / 2;
        double previousValue = array1[0] + array2[0] / 2.0;
        while (count <= medianLocation) {
            double currentValue;

            if (array1Index >= array1.length) {
                currentValue = array2[array2Index];
                array2Index++;
            } else if (array2Index >= array2.length){
                currentValue = array1[array1Index];
                array1Index++;
            } else if (array1[array1Index] < array2[array2Index]){
                currentValue = array1[array1Index];
                array1Index++;
            } else {
                currentValue = array2[array2Index];
                array2Index++;
            }

            if (hasEvenNumberOfValues) {
                median = (previousValue + currentValue) / 2.0;
            } else {
                median = currentValue;
            }
            previousValue = currentValue;
            count++;
        }
        return median;
    }
}