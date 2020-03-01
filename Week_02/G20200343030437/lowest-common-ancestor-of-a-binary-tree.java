class Solution {

    public TreeNode ins;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后续遍历
        recursive(root, p, q);
        return ins;

    }
    public boolean recursive(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        int left = recursive(node.left, p, q) == true ? 1 : 0;
        
        int right = recursive(node.right, p, q) == true ? 1 : 0;

        int mid = (node == p || node == q) == true ? 1 : 0;

        if (left + right + mid >= 2) {
            this.ins = node;
        }

        return left + right + mid > 0;
    }

    
}
