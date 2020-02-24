package cn.geek.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，返回它的 前序 遍历
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月23日 07:07:00
 */
public class LeetCode_114_363 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderRecur(root, res);
        return res;
    }

    private void preOrderRecur(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        preOrderRecur(root.left, res);
        preOrderRecur(root.right, res);
    }

    /**
     * Preorder traversal by queue list.
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<Integer> preorderTraversalByQueue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (null == root) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            res.add(curr.val);
            if (null != curr.left) {
                queue.add(curr.left);
            }
            if (null != curr.right) {
                queue.add(curr.right);
            }
        }
        return res;
    }
}
