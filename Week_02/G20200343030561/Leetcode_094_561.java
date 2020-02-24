/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }
    
    public void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left, ans);
        ans.add(root.val);
        if (root.right != null) inOrder(root.right, ans);
        
    }
}
// @lc code=end

