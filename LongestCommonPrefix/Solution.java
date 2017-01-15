package LongestCommonPrefix;

import java.util.Arrays;

/**
 * Created by Wentao on 1/15/2017.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < first.length; i++) {
            if (first[i] == last[i]) {
                sb.append(first[i]);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
