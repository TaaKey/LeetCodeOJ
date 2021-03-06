package ImplementStrStr;

/**
 * Created by Wentao on 1/23/2017.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}

class Solution1 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
