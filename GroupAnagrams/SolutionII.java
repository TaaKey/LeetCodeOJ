package GroupAnagrams;

import java.util.*;

/**
 * Created by Wentao on 1/15/2017.
 */
public class SolutionII {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (String str : strs) {
            int key = 1;
            for (char ch : str.toCharArray()) {
                key *= prime[ch - 'a'];
            }
            List<String> tmp;
            if (map.containsKey(key)) {
                tmp = result.get(map.get(key));
            } else {
                tmp = new ArrayList<String>();
                result.add(tmp);
                map.put(key, result.size() - 1);
            }
            tmp.add(str);
        }
        return result;
    }
}
