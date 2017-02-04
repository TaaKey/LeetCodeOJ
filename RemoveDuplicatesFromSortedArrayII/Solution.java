package RemoveDuplicatesFromSortedArrayII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wentao on 2/4/2017.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
