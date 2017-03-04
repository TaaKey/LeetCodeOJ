package MinimumSizeSubarraySum;

/**
 * Created by whong53 on 3/3/17.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0, tmpSum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            tmpSum += nums[end];
            end++;
            while (tmpSum >= s) {
                min = Math.min(min, end - start);
                tmpSum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
