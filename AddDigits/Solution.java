package AddDigits;

/**
 * Created by whong53 on 2/6/17.
 */
public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            num = calculate(num);
        }
        return num;
    }

    private int calculate(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
