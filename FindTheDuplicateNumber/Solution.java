package FindTheDuplicateNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                result = num;
                break;
            }
        }
        return result;
    }
}

class Solution2 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}