/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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

    public List<Integer> pre_order_list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return pre_order_list;
    }

    private void helper(TreeNode current_node){
        if (current_node == null) return;

        pre_order_list.add(current_node.val);
        helper(current_node.left);
        helper(current_node.right);
    }
}
// @lc code=end

