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
    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root,p,q);
        return res;
    }

    public boolean recur(TreeNode currentNode,TreeNode p,TreeNode q){
        if(currentNode == null){
            return false;
        }
        int left = recur(currentNode.left,p,q) ? 1 : 0;
        int right = recur(currentNode.right,p,q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if(mid + left + right >= 2){
            res = currentNode;
        }
        return (mid + left + right) > 0;

    }
}