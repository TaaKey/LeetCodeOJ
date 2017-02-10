package TeemoAttacking;

/**
 * Created by Wentao on 2/9/2017.
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            result += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        result += duration;
        return result;
    }
}
