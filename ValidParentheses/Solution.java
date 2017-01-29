package ValidParentheses;

import java.util.Stack;

/**
 * Created by Wentao on 1/29/2017.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (s.charAt(i) == ')' && pop != '('
                        || s.charAt(i) == '}' && pop != '{'
                        || s.charAt(i) == ']' && pop != '['
                        ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
