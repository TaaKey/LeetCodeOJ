package ExcelSheetColumnTitle;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int val = n % 26;
            sb.insert(0, (char) ('A' + val));
            n = n / 26;
        }
        return sb.toString();
    }
}
