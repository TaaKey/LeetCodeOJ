package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[256];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }
        int max = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            i = Math.max(i, chars[s.charAt(j)] + 1);
            chars[s.charAt(j)] = j;
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
