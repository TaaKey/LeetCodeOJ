package TopKFrequentElements;

import java.util.*;

/**
 * Created by whong53 on 1/11/17.
 */
public class Solution {
    class Element implements Comparable<Element> {
        int value;
        int frequency;

        Element(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        public int compareTo(Element o) {
            // order by frequency desc
            return o.frequency - this.frequency;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Element> queue = new PriorityQueue<Element>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Element newElement = new Element((Integer) entry.getKey(), (Integer) entry.getValue());
            queue.add(newElement);
        }
        List<Integer> result = new ArrayList<Integer>();
        while (k > 0 && !queue.isEmpty()) {
            result.add(queue.poll().value);
            k--;
        }
        return result;
    }
}
