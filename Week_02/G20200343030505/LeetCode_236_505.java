class LeetCode_429_505 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode p1 = lowestCommonAncestor(root.left, p, q);
        TreeNode p2 = lowestCommonAncestor(root.right, p, q);

        if (p1 != null && p2 != null) {
            return root;
        }

        return p1 == null ?p2:p1;
    }
}