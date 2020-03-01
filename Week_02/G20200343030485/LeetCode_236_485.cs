/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode targetNode;

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TravelTree(root, p, q);
        return targetNode;
    }

    public bool TravelTree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        int left = TravelTree(node.left, p, q) ? 1 : 0;
        int right = TravelTree(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;

        if (left + right + mid >= 2) {
            targetNode = node;
        }

        return (left + right + mid > 0);
    }
}