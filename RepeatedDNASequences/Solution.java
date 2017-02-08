package RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Wentao on 2/7/2017.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        int i = 0;
        while (i + 10 <= s.length()) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            }
            set.add(sub);
            i++;
        }
        return result.stream().collect(Collectors.toList());
    }
}
