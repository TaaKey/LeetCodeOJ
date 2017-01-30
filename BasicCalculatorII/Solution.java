package BasicCalculatorII;

import java.util.Stack;

/**
 * Created by whong53 on 1/30/17.
 */
public class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                number = number * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                }
                if (sign == '-') {
                    stack.push(-number);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = s.charAt(i);
                number = 0;
            }
        }
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;
    }
}
