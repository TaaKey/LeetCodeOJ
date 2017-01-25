package HammingDistance;

/**
 * Created by Wentao on 1/24/2017.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

class Solution2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> 1) & 1;
        }
        return count;
    }
}
