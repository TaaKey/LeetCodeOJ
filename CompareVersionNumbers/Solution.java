package CompareVersionNumbers;

import java.util.Arrays;

/**
 * Created by Wentao on 2/2/2017.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vArray1 = version1.split("\\.");
        while (vArray1.length > 0 && Integer.valueOf(vArray1[vArray1.length - 1]) == 0) {
            vArray1 = Arrays.copyOfRange(vArray1, 0, vArray1.length - 1);
        }
        String[] vArray2 = version2.split("\\.");
        while (vArray2.length > 0 && Integer.valueOf(vArray2[vArray2.length - 1]) == 0) {
            vArray2 = Arrays.copyOfRange(vArray2, 0, vArray2.length - 1);
        }
        int i;
        for (i = 0; i < Math.min(vArray1.length, vArray2.length); ) {
            if (Integer.valueOf(vArray1[i]) < Integer.valueOf(vArray2[i])) {
                return -1;
            } else if (Integer.valueOf(vArray1[i]) > Integer.valueOf(vArray2[i])) {
                return 1;
            } else {
                i++;
            }
        }
        if (vArray1.length > vArray2.length) {
            return 1;
        } else if (vArray1.length < vArray2.length) {
            return -1;
        } else {
            return 0;
        }
    }
}
