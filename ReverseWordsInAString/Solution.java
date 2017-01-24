package ReverseWordsInAString;

/**
 * Created by Wentao on 1/23/2017.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
