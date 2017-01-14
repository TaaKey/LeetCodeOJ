package LinkedListRandomNode;

import Util.ListNode;

import java.util.Random;

/**
 * Created by Wentao on 1/14/2017.
 */
public class Solution {

    ListNode head;
    Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode curr = head;
        ListNode result = null;
        for (int i = 1; curr != null; i++) {
            if (random.nextInt(i) == 0) {
                result = curr;
            }
            curr = curr.next;
        }
        return result.val;
    }
}
