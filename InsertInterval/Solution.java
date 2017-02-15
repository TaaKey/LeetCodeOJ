package InsertInterval;

import Util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Wentao on 2/14/2017.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> (a.start - b.start));
        queue.add(newInterval);
        for (Interval interval : intervals) {
            queue.add(interval);
        }
        List<Interval> result = new ArrayList<>();
        Interval first = queue.poll();
        while (!queue.isEmpty()) {
            Interval second = queue.poll();
            List<Interval> merged = merge(first, second);
            if (merged.size() > 1) {
                result.add(first);
                first = merged.get(1);
            } else {
                first = merged.get(0);
            }
        }
        result.add(first);
        return result;
    }

    private List<Interval> merge(Interval first, Interval second) {
        if (first.end >= second.start) {
            return Arrays.asList(new Interval(Math.min(first.start, second.start), Math.max(first.end, second.end)));
        } else {
            return Arrays.asList(first, second);
        }
    }
}
