package MergeTwoSortedLists;

import Util.ListNode;

/**
 * Created by whong53 on 1/24/17.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode pointer = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 != null) {
            pointer.next = l1;
        } else {
            pointer.next = l2;
        }
        return fakeHead.next;
    }
}
