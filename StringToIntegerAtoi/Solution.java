package StringToIntegerAtoi;

/**
 * Created by whong53 on 3/1/17.
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();
        int sign = 1, idx = 0;
        long result = 0;
        if (str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (str.charAt(idx) == '+') {
            idx++;
        } else if (!Character.isDigit(str.charAt(idx))) {
            return 0;
        }
        int power = 1;
        for (int i = idx; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) result * sign;
            }
            result = result * 10 + str.charAt(i) - '0';
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) result * sign;
    }
}
