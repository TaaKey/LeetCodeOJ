package MultiplyStrings;

/**
 * Created by whong53 on 1/12/17.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] multi = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                multi[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = n1 + n2 - 1; i >= 0; i--) {
            int digit = (multi[i] + carry) % 10;
            carry = (multi[i] + carry) / 10;
            multi[i] = digit;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : multi) {
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

