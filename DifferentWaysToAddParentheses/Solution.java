package DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao on 3/4/2017.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1, input.length());
                List<Integer> lresult = diffWaysToCompute(left);
                List<Integer> rresult = diffWaysToCompute(right);
                for (int lr : lresult) {
                    for (int rr : rresult) {
                        if (input.charAt(i) == '+') {
                            result.add(lr + rr);
                        } else if (input.charAt(i) == '-') {
                            result.add(lr - rr);
                        } else if (input.charAt(i) == '*') {
                            result.add(lr * rr);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
