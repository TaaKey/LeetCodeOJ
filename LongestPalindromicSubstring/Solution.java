package LongestPalindromicSubstring;

/**
 * Created by Wentao on 1/20/2017.
 * Key idea, every time we move to right,
 * we only need to consider whether using this new character as tail could produce new palindrome
 * string of length (current length +1) or (current length +2)
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String result = "";
        int currentLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currentLen - 1, i)) {
                result = s.substring(i - currentLen - 1, i + 1);
                currentLen = currentLen + 2;
            } else if (isPalindrome(s, i - currentLen, i)) {
                result = s.substring(i - currentLen, i + 1);
                currentLen = currentLen + 1;
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0 || end >= s.length()) {
            return false;
        }
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
