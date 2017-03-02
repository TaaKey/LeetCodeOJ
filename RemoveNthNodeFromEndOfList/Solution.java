package RemoveNthNodeFromEndOfList;

import Util.ListNode;

/**
 * Created by whong53 on 3/1/17.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode p1 = fake, p2 = fake;
        while (n-- >= 0) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return fake.next;
    }
}
