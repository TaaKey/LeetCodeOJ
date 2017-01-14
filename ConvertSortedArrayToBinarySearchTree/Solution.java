package ConvertSortedArrayToBinarySearchTree;

import Util.TreeNode;

/**
 * Created by whong53 on 1/12/17.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = helper(nums, left, middle - 1);
        node.right = helper(nums, middle + 1, right);
        return node;
    }
}
