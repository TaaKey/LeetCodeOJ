package AddTwoNumbers;

import Util.ListNode;

/**
 * Created by whong53 on 1/9/17.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode point = fakeHead;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int currVal = (carry + l1.val + l2.val) % 10;
            point.next = new ListNode(currVal);
            carry = (carry + l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        while (l1 != null) {
            int currVal = (carry + l1.val) % 10;
            point.next = new ListNode(currVal);
            carry = (carry + l1.val) / 10;
            l1 = l1.next;
            point = point.next;
        }
        while (l2 != null) {
            int currVal = (carry + l2.val) % 10;
            point.next = new ListNode(currVal);
            carry = (carry + l2.val) / 10;
            l2 = l2.next;
            point = point.next;
        }
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return fakeHead.next;
    }
}
