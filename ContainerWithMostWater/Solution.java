package ContainerWithMostWater;

/**
 * Created by whong53 on 1/10/17.
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            maxArea = Math.max(maxArea, computerArea(left, right, height));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private int computerArea(int left, int right, int[] heights) {
        return (right - left) * Math.min(heights[right], heights[left]);
    }
}
