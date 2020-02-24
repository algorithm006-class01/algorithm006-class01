package cn.geek.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月18日 15:36:00
 */
public class LeetCode_094_363 {

    /**
     * Inorder traversal by stack list. 中序遍历  通过迭代的方式
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<Integer> inorderTraversalByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        // 中序遍历
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     *
     * Inorder traversal list. 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    /**
     * Helper.
     *
     * @param root
     *            the root
     * @param res
     *            the res
     */
    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args) {

    }
}
