package PowerOfFour;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
