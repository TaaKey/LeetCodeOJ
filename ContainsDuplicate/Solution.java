package ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by whong53 on 2/28/17.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return !(nums.length == set.size());
    }
}
