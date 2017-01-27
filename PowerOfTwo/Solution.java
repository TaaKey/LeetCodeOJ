package PowerOfTwo;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
