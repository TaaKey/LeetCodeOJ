package SqrtX;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid + 1 > x / (mid + 1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

    }
}
