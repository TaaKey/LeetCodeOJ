package CombinationSumIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wentao on 1/31/2017.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int start, int k, int target) {
        if (target == 0 && tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i <= 9; i++) {
                tmp.add(i);
                backtrack(result, tmp, i + 1, k, target - i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
