package GuessNumberHigherOrLower;

/**
 * Created by Wentao on 2/9/2017.
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) > 0) {
                left = mid + 1;
            } else if (guess(mid) < 0) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}

class GuessGame {
    int guess(int num) {
        return 0;
    }
}
