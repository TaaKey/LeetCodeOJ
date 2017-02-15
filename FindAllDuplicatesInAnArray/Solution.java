package FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 2/14/2017.
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
