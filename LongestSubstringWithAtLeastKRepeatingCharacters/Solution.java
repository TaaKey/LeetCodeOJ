package LongestSubstringWithAtLeastKRepeatingCharacters;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        char[] array = s.toCharArray();
        return helper(array, 0, array.length, k);
    }

    private int helper(char[] array, int start, int end, int k) {
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[array[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                for (int j = start; j < end; j++) {
                    if (array[j] == i + 'a') {
                        int left = helper(array, start, j, k);
                        int right = helper(array, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
