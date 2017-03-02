package ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whong53 on 3/2/17.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer prev = map.get(sum);
            if (prev != null && i - prev > 1) {
                return true;
            } else if (prev == null) {
                map.put(sum, i);
            }
        }
        return false;
    }
}
