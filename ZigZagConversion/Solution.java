package ZigZagConversion;

/**
 * Created by Wentao on 2/20/2017.
 */
public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int idx = 0;
        while (idx < len) {
            for (int i = 0; i < numRows && idx < len; i++) {
                sb[i].append(c[idx++]);
            }
            for (int i = numRows - 2; i >= 1 && idx < len; i--) {
                sb[i].append(c[idx++]);
            }
        }
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
