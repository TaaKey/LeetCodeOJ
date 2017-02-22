package FindRightInterval;

import Util.Interval;

import java.util.*;

/**
 * Created by whong53 on 2/22/17.
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            result[i] = key == null ? -1 : map.get(key);
        }
        return result;
    }
}

class Solution2 {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
            list.add(intervals[i].start);
        }
        Collections.sort(list);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i].end;
            int start = binarySearch(list, end);
            if (start < end) {
                result[i] = -1;
            } else {
                result[i] = map.get(start);
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return list.get(l);
    }
}