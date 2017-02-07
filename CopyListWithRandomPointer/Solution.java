package CopyListWithRandomPointer;

import Util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wentao on 2/7/2017.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode point = head;
        while (point != null) {
            map.put(point, new RandomListNode(point.label));
            point = point.next;
        }
        point = head;
        while (point != null) {
            map.get(point).next = map.get(point.next);
            map.get(point).random = map.get(point.random);
            point = point.next;
        }
        return map.get(head);
    }
}
