package week2.lowest_common_ancestor_of_a_binary_tree;

public class Solution {
    public TreeNode answer = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root,p,q);
        return this.answer;
    }
    public boolean recursion(TreeNode node, TreeNode p, TreeNode q){
        if (node == null){
            return false;
        }
        int left = this.recursion(node.left,p,q)?1:0;
        int right = this.recursion(node.right,p,q)?1:0;
        int root = (node==p||node==q)?1:0;

        if (left+right+root == 2){
            this.answer = node;
        }
        return  (left+right+root>0);
    }


}
