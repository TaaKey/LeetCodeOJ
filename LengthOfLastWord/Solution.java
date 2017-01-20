package LengthOfLastWord;

/**
 * Created by Wentao on 1/20/2017.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] list = s.trim().split("\\s+");
        return list[list.length - 1].length();
    }
}
