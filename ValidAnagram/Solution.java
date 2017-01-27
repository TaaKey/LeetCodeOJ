package ValidAnagram;

import java.util.Arrays;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }

    public boolean isAnagram2(String s, String t) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i) - 'a']--;
        }
        for (int i : letters) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
