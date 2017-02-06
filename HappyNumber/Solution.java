package HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by whong53 on 2/6/17.
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> notHappy = new HashSet<>();
        while (!notHappy.contains(n)) {
            if (n == 1) {
                return true;
            } else {
                notHappy.add(n);
            }
            n = calculate(n);
        }
        return false;
    }

    private int calculate(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
