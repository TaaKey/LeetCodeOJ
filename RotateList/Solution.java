package RotateList;

import Util.ListNode;

/**
 * Created by Wentao on 1/28/2017.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode fast = fakeHead, slow = fakeHead;
        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }
        fast.next = fakeHead.next;
        fakeHead.next = slow.next;
        slow.next = null;
        return fakeHead.next;
    }
}
