package MaximumSubarray;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i - 1] > 0 ? dp[i - 1] : 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
