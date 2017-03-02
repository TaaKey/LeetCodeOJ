package DivideTwoIntegers;

/**
 * Created by whong53 on 3/2/17.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long ldivident = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (ldivident < ldivisor) {
            return 0;
        }
        int result;
        long lresult = ldivide(ldivident, ldivisor);
        if (lresult > Integer.MAX_VALUE) {
            result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            result = (int) (sign * lresult);
        }
        return result;
    }

    private long ldivide(long ldivident, long ldivisor) {
        if (ldivident < ldivisor) {
            return 0;
        }
        long sum = ldivisor, multiplier = 1;
        while (sum + sum <= ldivident) {
            sum += sum;
            multiplier += multiplier;
        }
        return multiplier + ldivide(ldivident - sum, ldivisor);
    }
}
