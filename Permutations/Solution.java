package Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 1/21/2017.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpResult, int[] nums) {
        if (tmpResult.size() == nums.length) {
            result.add(new ArrayList<>(tmpResult));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpResult.contains(nums[i])) {
                    continue;
                }
                tmpResult.add(nums[i]);
                backtrack(result, tmpResult, nums);
                tmpResult.remove(tmpResult.size() - 1);
            }
        }
    }
}
