package GroupAnagrams;

import java.util.*;

/**
 * Created by Wentao on 1/15/2017.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String tmp = String.valueOf(charArray);
            if (map.containsKey(tmp)) {
                List<String> list = map.get(tmp);
                list.add(str);
                map.put(tmp, list);
            } else {
                map.put(tmp, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            result.add((List<String>) entry.getValue());
        }
        return result;
    }
}
