package ConvertSortedListToBinarySearchTree;

import Util.ListNode;
import Util.TreeNode;

/**
 * Created by whong53 on 1/12/17.
 */

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode treeNode = helper(head, null);
        return treeNode;
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        mid.left = helper(head, slow);
        mid.right = helper(slow.next, tail);
        return mid;
    }
}
