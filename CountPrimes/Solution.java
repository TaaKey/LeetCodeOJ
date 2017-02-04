package CountPrimes;

import java.util.Arrays;

/**
 * Created by Wentao on 2/4/2017.
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                isNotPrime[i * j] = true;
            }
        }
        return count;
    }
}
