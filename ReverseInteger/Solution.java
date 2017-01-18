package ReverseInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 1/17/2017.
 */
public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) result;
    }
}
