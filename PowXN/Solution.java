package PowXN;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double subRes = myPow(x, n / 2);
        return (n % 2 == 0) ? subRes * subRes : n < 0 ? subRes * subRes / x : subRes * subRes * x;
    }
}
