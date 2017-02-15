package DeleteNodeInALinkedList;

import Util.ListNode;

/**
 * Created by whong53 on 2/15/17.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
