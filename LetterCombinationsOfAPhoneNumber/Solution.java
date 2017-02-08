package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wentao on 2/7/2017.
 */
public class Solution {
    private static String[] lib = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        calculate("", result, digits, 0);
        return result;
    }

    private void calculate(String tmp, List<String> result, String digits, int start) {
        if (start >= digits.length()) {
            result.add(tmp);
            return;
        }
        for (char c : lib[Character.getNumericValue(digits.charAt(start))].toCharArray()) {
            calculate(tmp + c, result, digits, start + 1);
        }
    }
}

class Solution2 {
    public List<String> letterCombinations(String digits) {
        String[] lib = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (result.peek().length() == i) {
                String tmp = result.poll();
                for (char c : lib[Character.getNumericValue(digits.charAt(i))].toCharArray()) {
                    result.add(tmp + c);
                }
            }
        }
        return result;
    }
}
