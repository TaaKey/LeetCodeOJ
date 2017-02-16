package PartitionList;

import Util.ListNode;

/**
 * Created by whong53 on 2/15/17.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode point1 = head1;
        ListNode head2 = new ListNode(-1);
        ListNode point2 = head2;
        while (head != null) {
            if (head.val < x) {
                point1.next = head;
                point1 = point1.next;
            } else {
                point2.next = head;
                point2 = point2.next;
            }
            head = head.next;
        }
        point1.next = head2.next;
        point2.next = null;
        return head1.next;
    }
}
