package HammingDistance;

/**
 * Created by Wentao on 1/24/2017.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
