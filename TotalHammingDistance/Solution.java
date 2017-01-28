package TotalHammingDistance;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int num1 : nums) {
            for (int num2 : nums) {
                result += Integer.bitCount(num1 ^ num2);
            }
        }
        return result / 2;
    }

    public int totalHammingDistance2(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < nums.length; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            // if there are n integers in the array and k of them have a particular bit set and (n-k) do not,
            // then that bit contributes k*(n-k) hamming distance to the total.
            result += bitCount * (nums.length - bitCount);
        }
        return result;
    }
}
