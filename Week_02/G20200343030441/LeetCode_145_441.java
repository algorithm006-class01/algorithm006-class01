import java.util.List;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorder_list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return postorder_list;
    }

    private void helper(TreeNode current_node){
        if (current_node == null) return;

        helper(current_node.left);
        helper(current_node.right);
        postorder_list.add(current_node.val);
    }
}
// @lc code=end

