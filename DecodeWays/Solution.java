package DecodeWays;

import javax.sound.midi.SysexMessage;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6' ||
                    s.charAt(i - 2) == '1' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
