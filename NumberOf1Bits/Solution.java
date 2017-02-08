package NumberOf1Bits;

/**
 * Created by Wentao on 2/7/2017.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
