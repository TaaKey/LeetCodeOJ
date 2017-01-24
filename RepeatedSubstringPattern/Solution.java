package RepeatedSubstringPattern;

import java.util.Arrays;

/**
 * Created by Wentao on 1/23/2017.
 */

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            if (str.length() % i == 0) {
                String[] split = str.split(str.substring(0, i));
                if (split.length == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
