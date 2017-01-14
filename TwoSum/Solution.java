package TwoSum;

import java.util.HashMap;

/**
 * Created by whong53 on 1/13/17.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = Math.min(i, map.get(target - nums[i]));
                result[1] = Math.max(i, map.get(target - nums[i]));
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
