import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //Time complexity worst case: O(n)
    //
    //Space  complexity worst case: O(n)
    //
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        int[] indices = new int[]{};
        Map<Integer, Integer> differenceToIndexMap = new HashMap<>();
        boolean found = false;
        int index = 0;
        while (!found && index < nums.length) {
            Integer currentPart = nums[index];
            Integer partOneIndex = differenceToIndexMap.get(currentPart);
            if (partOneIndex != null) {
                indices = new int[]{partOneIndex, index};
                found = true;
            } else {
                Integer difference = target - currentPart;
                differenceToIndexMap.put(difference, index);
            }
            index++;
        }
        return indices;
    }
}
