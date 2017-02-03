package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wentao on 2/2/2017.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> item, int start) {
        result.add(new ArrayList<>(item));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            item.add(nums[i]);
            backtrack(nums, result, item, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
