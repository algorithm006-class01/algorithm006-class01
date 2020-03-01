package cn.geek.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月20日 09:15:00
 */
public class LeetCode_226_363 {

    public TreeNode invertTree(TreeNode root) {

        // 递归出口
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * Invert tree by queue tree node.
     *
     * @param root
     *            the root
     * @return the tree node
     */
    public TreeNode invertTreeByQueue(TreeNode root) {

        // 队列是先进先出
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode tempNode = current.left;
            current.left = current.right;
            current.right = tempNode;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }
}
