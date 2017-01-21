package RemoveKDigits;

/**
 * Created by Wentao on 1/20/2017.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        int n = num.length();
        int l = num.length() - k;
        char[] numArray = num.toCharArray();
        char[] result = new char[l];
        int index = 0;
        for (int i = 0; i < n; i++) {
            while (n - i > l - index && index > 0 && numArray[i] < result[index - 1]) {
                index--;
            }
            if (index < l) {
                result[index++] = numArray[i];
            }
        }
        index = -1;
        while (++index < l) {
            if (result[index] != '0') {
                break;
            }
        }
        String s = new String(result).substring(index);
        return s.length() == 0 ? "0" : s;
    }
}
