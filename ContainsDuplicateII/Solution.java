package ContainsDuplicateII;

import java.util.*;

/**
 * Created by whong53 on 2/28/17.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(0, i);
            if (map.get(nums[i]).size() > 1 && map.get(nums[i]).get(0) - map.get(nums[i]).get(1) <= k) {
                return true;
            }
        }
        return false;
    }
}
