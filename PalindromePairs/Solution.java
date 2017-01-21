package PalindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wentao on 1/20/2017.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        if (map.containsKey("")) {
            int blankIndex = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i]) && i != blankIndex) {
                    result.add(Arrays.asList(i, blankIndex));
                    result.add(Arrays.asList(blankIndex, i));
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            String currentReversed = reverseString(words[i]);
            if (map.containsKey(currentReversed) && map.get(currentReversed) != i) {
                result.add(Arrays.asList(i, map.get(currentReversed)));
            }
        }
        for (int i = 0; i < words.length; i++) {
            String currentStr = words[i];
            for (int cut = 1; cut < currentStr.length(); cut++) {
                if (isPalindrome(currentStr.substring(0, cut))) {
                    String reversedCut = reverseString(currentStr.substring(cut));
                    if (map.containsKey(reversedCut) && i != map.get(reversedCut)) {
                        result.add(Arrays.asList(map.get(reversedCut), i));
                    }
                }
                if (isPalindrome(currentStr.substring(cut)))  {
                    String reversedCut = reverseString(currentStr.substring(0, cut));
                    if (map.containsKey(reversedCut) && i != map.get(reversedCut)) {
                        result.add(Arrays.asList(i, map.get(reversedCut)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private String reverseString (String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }
}
