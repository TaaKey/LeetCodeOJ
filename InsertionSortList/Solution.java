package InsertionSortList;

import Util.ListNode;

/**
 * Created by whong53 on 1/24/17.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            ListNode point = fakeHead;
            while (point.next != null && point.next.val < curr.val) {
                point = point.next;
            }
            curr.next = point.next;
            point.next = curr;
            curr = next;
        }
        return fakeHead.next;
    }
}
