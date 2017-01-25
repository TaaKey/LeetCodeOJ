package UniqueSubstringsInWraparoundString;

/**
 * Created by Wentao on 1/24/2017.
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxLen = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            int j = p.charAt(i) - 'a';
            count[j] = Math.max(count[j], maxLen);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}
