package Heaters;

import java.util.Arrays;

/**
 * Created by Wentao on 1/26/2017.
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, result = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && house - heaters[i] >= heaters[i + 1] - house) {
                i++;
            }
            result = Math.max(result, Math.abs(heaters[i] - house));
        }
        return result;
    }
}
