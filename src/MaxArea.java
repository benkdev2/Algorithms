public class MaxArea {
    // Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    // n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    // Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    // Note: You may not slant the container and n is at least 2.
    //
    //Time complexity worst case of this solution: O(n^2)
    //
    //Space complexity worst case of this solution: O(1)
    //
    //There is a more efficient solution that I didn't think of on first pass.
    //
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        } else if (height.length == 1) {
            return height[0];
        }

        int maxAreaNum = 0;
        for (int rightBound = height.length - 1; rightBound > 0; rightBound--) {
            for (int leftBound = 0; leftBound < rightBound; leftBound++) {
                int newMaxArea = calculateArea(height, leftBound, rightBound);
                if (newMaxArea > maxAreaNum) {
                    maxAreaNum = newMaxArea;
                }
            }
        }
        return maxAreaNum;
    }

    private int calculateArea(int[] height, int leftBound, int rightBound) {
        int maxHeight = Math.min(height[leftBound], height[rightBound]);
        int area = (rightBound - leftBound) * maxHeight;
        return area;
    }
}
