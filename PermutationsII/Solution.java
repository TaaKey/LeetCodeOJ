package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wentao on 1/21/2017.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int[] nums, boolean[] used) {
        if (tmpResult.size() == nums.length) {
            result.add(new ArrayList<>(tmpResult));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tmpResult.add(nums[i]);
                backtrack(result, tmpResult, nums, used);
                used[i] = false;
                tmpResult.remove(tmpResult.size() - 1);
            }
        }
    }
}
