package LongestValidParentheses;

import java.util.Stack;

/**
 * Created by whong53 on 2/16/17.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                left = i + 1;
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - left + 1);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
