package RemoveDuplicatesFromSortedList;

import Util.ListNode;

/**
 * Created by whong53 on 2/15/17.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode point = head;
        while (point != null && point.next != null) {
            if (point.val == point.next.val) {
                point.val = point.next.val;
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return head;
    }
}

class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
