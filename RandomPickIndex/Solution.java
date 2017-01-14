package RandomPickIndex;

import java.util.Random;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {

    Random random;
    int[] nums;

    public Solution(int[] nums) {
        this.random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        int match = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                match++;
                if (random.nextInt(match) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
