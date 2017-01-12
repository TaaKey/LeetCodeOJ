package PopulatingNextRightPointersInEachNode;

import Util.TreeLinkNode;

/**
 * Created by whong53 on 1/12/17.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode curr = level;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
    }
}
