package DataStreamAsDisjointIntervals;

import Util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by whong53 on 2/28/17.
 */
public class SummaryRanges {

    TreeMap<Integer, Interval> map;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        this.map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer left = map.lowerKey(val);
        Integer right = map.higherKey(val);
        // insert 2 into (..., 1] and [3, ...)
        if (left != null && right != null && map.get(left).end == val - 1 && map.get(right).start == val + 1) {
            map.get(left).end = map.get(right).end;
            map.remove(right);
        }
        // insert 4 into [3, ...)
        else if (left != null && map.get(left).end >= val - 1) {
            map.get(left).end = Math.max(map.get(left).end, val);
        }
        // insert 0 into (..., 1]
        else if (right != null && map.get(right).start <= val + 1) {
            map.get(right).start = Math.min(map.get(right).start, val);
        }
        // insert 2 into (..., 0] and [5, ...)
        else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
