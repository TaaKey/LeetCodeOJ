package ReverseVowelsOfAString;

import java.util.HashSet;

/**
 * Created by Wentao on 1/15/2017.
 */
public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(String.valueOf(charArray[left]))) {
                left++;
            }
            while (left < right && !vowels.contains(String.valueOf(charArray[right]))) {
                right--;
            }
            swap(charArray, left, right);
            left++;
            right--;
        }
        return String.valueOf(charArray);
    }

    private void swap(char[] chars, int i1, int i2) {
        char tmp = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = tmp;
    }
}
