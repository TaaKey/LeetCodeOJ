package DistinctSubsequences;

import java.util.Arrays;

/**
 * Created by whong53 on 1/9/17.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int[][] nums = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[s.length()][t.length()];
    }
}
