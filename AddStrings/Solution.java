package AddStrings;

/**
 * Created by whong53 on 1/9/17.
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        char[] numChars1 = num1.toCharArray();
        char[] numChars2 = num2.toCharArray();
        int i = numChars1.length - 1;
        int j = numChars2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? (numChars1[i--] - '0') : 0;
            int b = j >= 0 ? (numChars2[j--] - '0') : 0;
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        return sb.toString();
    }
}
