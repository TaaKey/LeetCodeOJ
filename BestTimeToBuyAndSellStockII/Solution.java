package BestTimeToBuyAndSellStockII;

/**
 * Created by whong53 on 2/17/17.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            result += (prices[i + 1] - prices[i] > 0 ? prices[i + 1] - prices[i] : 0);
        }
        return result;
    }
}
