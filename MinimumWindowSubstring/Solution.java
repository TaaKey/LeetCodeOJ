package MinimumWindowSubstring;

/**
 * Created by whong53 on 3/3/17.
 */
public class Solution {
    public String minWindow(String s, String t) {
        String minStr = "";
        int dist = Integer.MAX_VALUE;
        int[] tmap = new int[256];
        for (char c : t.toCharArray()) {
            tmap[c]++;
        }
        int tcnt = t.length(), scnt = 0, i = 0, j = 0;
        for (i = 0; i < s.length(); i++) {
            if (tmap[s.charAt(i)] > 0) {
                scnt++;
            }
            tmap[s.charAt(i)]--;
            while (scnt >= tcnt) {
                if (dist > i - j + 1) {
                    dist = i - j + 1;
                    minStr = s.substring(j, i + 1);
                }
                tmap[s.charAt(j)]++;
                if (tmap[s.charAt(j)] > 0) {
                    scnt--;
                }
                j++;
            }
        }
        return minStr;
    }
}
