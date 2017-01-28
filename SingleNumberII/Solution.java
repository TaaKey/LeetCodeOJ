package SingleNumberII;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if (sum != 0) {
                result = result | (sum << i);
            }
        }
        return result;
    }
}
