package ArrangingCoins;

/**
 * Created by Wentao on 1/22/2017.
 */
public class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        long i = 1;
        long nLong = (long) n;
        while (i * i + i <= 2 * nLong) {
            i++;
        }
        return (int) i - 1;
    }

    public int arrangeCoins2(int n) {
        if (n <= 0) {
            return 0;
        }
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (0.5 * mid + 0.5 * mid * mid <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
