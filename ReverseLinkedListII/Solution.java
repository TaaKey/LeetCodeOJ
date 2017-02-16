package ReverseLinkedListII;

import Util.ListNode;

/**
 * Created by whong53 on 2/15/17.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tmp = start.next;
            start.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        return fakeHead.next;
    }
}
