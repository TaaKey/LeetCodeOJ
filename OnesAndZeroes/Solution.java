package OnesAndZeroes;

/**
 * Created by Wentao on 2/19/2017.
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int[] cost = count(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= cost[0] && k >= cost[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cost[0]][k - cost[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] cost = count(str);
            for (int i = m; i >= cost[0]; i--) {
                for (int j = n; j >= cost[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cost[0]][j - cost[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int[] cost = new int[2];
        for (int i = 0; i < str.length(); i++) {
            cost[str.charAt(i) - '0']++;
        }
        return cost;
    }
}
