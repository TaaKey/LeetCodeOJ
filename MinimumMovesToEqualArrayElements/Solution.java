package MinimumMovesToEqualArrayElements;

/**
 * Created by whong53 on 2/6/17.
 */
public class Solution {
    // Adding 1 to n-1 elements is same as subtracting 1 from 1 element
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }
}
