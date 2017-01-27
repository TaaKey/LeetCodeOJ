package RemoveDuplicateLetters;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            cnt[s.charAt(i) - 'a']--;
            if (cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.isEmpty() ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
    }
}