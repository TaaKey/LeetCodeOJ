package HouseRobberII;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int include = 0;
        int exclude = 0;
        for (int i = start; i <= end; i++) {
            int preInclude = include;
            int preExclude = exclude;
            include = nums[i] + preExclude;
            exclude = Math.max(preExclude, preInclude);
        }
        return Math.max(include, exclude);
    }
}
