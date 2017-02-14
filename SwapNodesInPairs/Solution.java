package SwapNodesInPairs;

import Util.ListNode;

/**
 * Created by Wentao on 2/13/2017.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;
        return node;
    }
}
