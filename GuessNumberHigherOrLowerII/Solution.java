package GuessNumberHigherOrLowerII;

/**
 * Created by Wentao on 2/9/2017.
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return dp(dp, 1, n);
    }

    private int dp(int[][] dp, int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (dp[s][e] != 0) {
            return dp[s][e];
        }
        int result = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            int tmp = i + Math.max(dp(dp, s, i - 1), dp(dp, i + 1, e));
            result = Math.min(result, tmp);
        }
        dp[s][e] = result;
        return result;
    }
}
