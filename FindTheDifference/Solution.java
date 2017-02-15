package FindTheDifference;

/**
 * Created by Wentao on 2/14/2017.
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int code = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            code -= (int) s.charAt(i);
            code += (int) t.charAt(i);
        }
        return (char) code;
    }

    public char findTheDifference2(String s, String t) {
        int code = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            code ^= s.charAt(i);
            code ^= t.charAt(i);
        }
        return (char) code;
    }
}
