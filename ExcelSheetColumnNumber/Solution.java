package ExcelSheetColumnNumber;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return result;
    }
}
