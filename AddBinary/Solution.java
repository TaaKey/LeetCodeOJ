package AddBinary;

/**
 * Created by whong53 on 1/30/17.
 */
public class Solution {
    public String addBinary(String a, String b) {
        int c = 0;
        int d = 0;
        StringBuilder sb = new StringBuilder();
        int ai, bi;
        for (ai = a.length() - 1, bi = b.length() - 1; ai >= 0 && bi >= 0; ai--, bi--) {
            int sum = a.charAt(ai) - '0' + b.charAt(bi) - '0' + c;
            d = sum % 2;
            c = sum / 2;
            sb.insert(0, String.valueOf(d));
        }
        for (int i = ai; i >= 0; i--) {
            int sum = a.charAt(i) - '0' + c;
            d = sum % 2;
            c = sum / 2;
            sb.insert(0, String.valueOf(d));
        }
        for (int i = bi; i >= 0; i--) {
            int sum = b.charAt(i) - '0' + c;
            d = sum % 2;
            c = sum / 2;
            sb.insert(0, String.valueOf(d));
        }
        if (c > 0) {
            sb.insert(0, String.valueOf(c));
        }
        return sb.toString();
    }
}
