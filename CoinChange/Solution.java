package CoinChange;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int defaultCount = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    int temp = dp[i - coin] + 1;
                    defaultCount = defaultCount < 0 ? temp : Math.min(defaultCount, temp);
                }
            }
            dp[i] = defaultCount;
        }
        return dp[amount];
    }
}
