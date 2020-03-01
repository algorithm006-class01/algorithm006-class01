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
    TreeNode f;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        help(root, p, q);
        return f;
    }
    public boolean help(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;

        int left = help(root.left, p, q) ? 1:0;
        int right = help(root.right, p, q) ? 1:0;

        int mid = 0;
        if(root == p || root ==q){
            mid = 1;
        }

        if((mid+left+right)>=2)
            f = root;

        return (mid + left + right)>0;
    }
}