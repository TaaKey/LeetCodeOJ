package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whong53 on 3/3/17.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            backtrack(result, tmp, i + 1, n, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
