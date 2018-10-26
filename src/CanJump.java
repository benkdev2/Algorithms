import java.util.ArrayDeque;
import java.util.Deque;

public class CanJump {

    //Given an array of non-negative integers, you are initially positioned at the first index of the array.
    //
    //Each element in the array represents your maximum jump length at that position.
    //
    //Determine if you are able to reach the last index.
    //
    //First solution to the problem I thought of was using Deques. There's a better solution to this one.
    //
    //Time complexity worst case - O(n^n)
    //
    //Space complexity worst case - O(n)
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Deque<Integer> jumpNumbersDeque = new ArrayDeque<>();
        Deque<Integer> indexDeque = new ArrayDeque<>();

        boolean canJump = false;
        int currentIndex = 0;
        jumpNumbersDeque.addLast(nums[currentIndex]);
        indexDeque.addLast(currentIndex);

        while (jumpNumbersDeque.size() != 0 && !canJump) {
            if (currentIndex == nums.length - 1) {
                canJump = true;
            } else if (currentIndex > nums.length - 1 || jumpNumbersDeque.getLast() == 0) {
                currentIndex = indexDeque.getLast();
                decrementLastAndReAdd(jumpNumbersDeque, indexDeque);
            } else {
                currentIndex = indexDeque.getLast();
                int jumpByNumber = jumpNumbersDeque.getLast();
                currentIndex += jumpByNumber;
                if (currentIndex < nums.length) {
                    indexDeque.addLast(currentIndex);
                    jumpNumbersDeque.addLast(nums[currentIndex]);
                }
            }
        }
        return canJump;
    }

    private void decrementLastAndReAdd(Deque<Integer> jumpNumbersDeque, Deque<Integer> indexDeque) {
        if (jumpNumbersDeque.size() == 0) {
            return;
        }

        int currentNum = jumpNumbersDeque.getLast();
        currentNum--;

        if (currentNum > 0) {
            jumpNumbersDeque.removeLast();
            jumpNumbersDeque.addLast(currentNum);
        } else {
            jumpNumbersDeque.removeLast();
            if  (indexDeque.size() > 0) {
                indexDeque.removeLast();
            }
            decrementLastAndReAdd(jumpNumbersDeque, indexDeque);
        }
    }
}
