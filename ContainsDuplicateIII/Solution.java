package ContainsDuplicateIII;

import java.util.*;

/**
 * TreeSet Solution O(nlogk)
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        Long floor, ceiling;
        for (int i = 0; i < nums.length; i++) {
            floor = set.floor(Long.valueOf(nums[i]) + t);
            ceiling = set.ceiling(Long.valueOf(nums[i]) - t);
            if (floor != null && floor >= nums[i] || ceiling != null && ceiling <= nums[i]) {
                return true;
            }
            set.add(Long.valueOf(nums[i]));
            if (i >= k) {
                set.remove(Long.valueOf(nums[i - k]));
            }
        }
        return false;
    }
}

/**
 * Buckets Solution O(n)
 */
class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long newNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = newNum / ((long) t + 1);
            if (map.containsKey(bucket) ||
                    map.containsKey(bucket - 1) && newNum - map.get(bucket - 1) <= t ||
                    map.containsKey(bucket + 1) && map.get(bucket + 1) - newNum <= t) {
                return true;
            }
            if (map.size() >= k) {
                long bucketToDelete = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(bucketToDelete);
            }
            map.put(bucket, newNum);
        }
        return false;
    }
}
