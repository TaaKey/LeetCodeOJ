package SumOfTwoIntegers;

/**
 * Created by whong53 on 1/9/17.
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
