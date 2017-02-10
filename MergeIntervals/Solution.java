package MergeIntervals;

import Util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Wentao on 2/9/2017.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> (a.start - b.start));
        for (Interval interval : intervals) {
            queue.add(interval);
        }
        Interval left = queue.poll();
        while (!queue.isEmpty()) {
            Interval right = queue.poll();
            List<Interval> mergeTwo = mergeTwo(left, right);
            if (mergeTwo.size() == 1) {
                left = mergeTwo.get(0);
            } else {
                result.add(mergeTwo.get(0));
                left = mergeTwo.get(1);
            }
        }
        result.add(left);
        return result;
    }

    private List<Interval> mergeTwo(Interval interval1, Interval interval2) {
        if (interval1.end >= interval2.start) {
            return Arrays.asList(new Interval(
                    Math.min(interval1.start, interval2.start),
                    Math.max(interval1.end, interval2.end)));
        } else {
            return Arrays.asList(interval1, interval2);
        }
    }
}
