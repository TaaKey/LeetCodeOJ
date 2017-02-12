package TargetSum;

/**
 * Created by Wentao on 2/12/2017.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int result = dfs(nums, 0, S);
        return result;
    }

    private int dfs(int[] nums, int start, int S) {
        if (start > nums.length - 1) {
            return 0;
        } else if (start == nums.length - 1) {
            if (nums[start] == S && nums[start] == -S) {
                return 2;
            } else if (nums[start] == S || nums[start] == -S) {
                return 1;
            }
        }
        int positiveCase = dfs(nums, start + 1, S - nums[start]);
        int negativeCase = dfs(nums, start + 1, S + nums[start]);
        return positiveCase + negativeCase;
    }
}
