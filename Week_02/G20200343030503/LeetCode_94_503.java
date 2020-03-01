/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 方式一、使用递归
 *  
 *
 *
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root,result);
        return result;
    }

    public void helper(TreeNode root,List<Integer> result) {
        if (root != null) {
            //递归所有左节点
            if (root.left != null) {
                helper(root.left,result);
            }
            result.add(root.val);
            //递归所有右节点
            if(root.right != null) {
                helper(root.right,result);
            }
        }
    }
}