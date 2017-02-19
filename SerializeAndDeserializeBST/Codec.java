package SerializeAndDeserializeBST;

import Util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wentao on 2/18/2017.
 */
public class Codec {

    private static final String SEP = ",";
    private static final String NULL = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
        } else {
            sb.append(node.val).append(SEP);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SEP)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String curr = queue.poll();
        if (curr.equals(NULL)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(curr));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
}
