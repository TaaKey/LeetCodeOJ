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
}
