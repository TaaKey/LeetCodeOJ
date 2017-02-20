package CombinationSumIV;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wentao on 1/31/2017.
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int result = 0;
        if (map.containsKey(target)) {
            return map.get(target);
        }
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += combinationSum4(nums, target - nums[i]);
            }
        }
        map.put(target, result);
        return result;
    }
}

class Solution2 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[target + 1];
        for (int i = 1; i < result.length; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    result[i]++;
                } else {
                    result[i] += result[i - num];
                }
            }
        }
        return result[target];
    }
}
