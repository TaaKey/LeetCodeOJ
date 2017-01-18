package RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Wentao on 1/18/2017.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        // LinkedHashSet preserves insert order and keep elements unique
        HashSet<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = 0;
        for (int num : set) {
            nums[i] = num;
            i++;
        }
        return set.size();
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1;
        for (int num : nums) {
            if (num > nums[i - 1]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
