package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by whong53 on 3/3/17.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String substring = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(substring)) {
                    if (copy.get(substring) == 1) {
                        copy.remove(substring);
                    } else {
                        copy.put(substring, copy.get(substring) - 1);
                    }
                    if (copy.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
