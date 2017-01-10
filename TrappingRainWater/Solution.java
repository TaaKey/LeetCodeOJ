package TrappingRainWater;

/**
 * Created by whong53 on 1/10/17.
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int result = 0;
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    result += leftHeight - height[left];
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (rightHeight > height[right]) {
                    result += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return result;
    }
}
