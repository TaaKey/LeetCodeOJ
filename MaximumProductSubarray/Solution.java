package MaximumProductSubarray;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newMax = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
            int newMin = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
            max = Math.max(newMax, max);
            preMax = newMax;
            preMin = newMin;
        }
        return max;
    }
}
