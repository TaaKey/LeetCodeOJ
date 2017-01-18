package ValidPalindrome;

/**
 * Created by whong53 on 1/18/17.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        String allLowerCase = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if (!Character.isLetterOrDigit(allLowerCase.charAt(left)) && left < right) {
                left++;
            } else if (!Character.isLetterOrDigit(allLowerCase.charAt(right)) && left < right) {
                right--;
            } else if (allLowerCase.charAt(left) != allLowerCase.charAt(right)) {
                isPalindrome = false;
                return isPalindrome;
            } else {
                left++;
                right--;
            }
        }
        return isPalindrome;
    }
}
