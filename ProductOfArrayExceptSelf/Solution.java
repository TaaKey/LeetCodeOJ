package ProductOfArrayExceptSelf;

/**
 * Created by Wentao on 1/20/2017.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int allProduct = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                allProduct *= num;
            }
        }
        if (zeroCount > 1) {
            return result;
        } else if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = allProduct;
                }
            }
            return result;
        } else {
            for (int i = 0; i < nums.length; i++) {
                result[i] = allProduct / nums[i];
            }
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int rightBase = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightBase;
            rightBase *= nums[i];
        }
        return result;
    }
}

