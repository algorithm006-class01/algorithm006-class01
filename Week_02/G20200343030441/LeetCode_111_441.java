/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode root, int level){
        if (root.left != null && root.right != null){
            level++;
            return Math.min(helper(root.left, level), helper(root.right, level));
        } else if (root.left == null && root.right == null){
            return level;
        } else if (root.left == null){
            level++;
            return helper(root.right, level);
        } else if (root.right == null){
            level++;
            return helper(root.left, level);
        }

        return level;
    }
}
// @lc code=end

