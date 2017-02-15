package ReverseNodesInKGroup;

import Util.ListNode;

/**
 * Created by whong53 on 2/15/17.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode tail = fakeHead, prev = fakeHead, tmp;
        int count;
        while (true) {
            count = k;
            while (count-- > 0 && tail != null) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            head = prev.next;
            while (prev.next != tail) {
                tmp = prev.next;
                prev.next = tmp.next;
                tmp.next = tail.next;
                tail.next = tmp;
            }
            tail = head;
            prev = head;
        }
        return fakeHead.next;
    }
}
