class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = new TreeNode(0);
        findNodeRoad(root, p, q, result);
        return result.left;
    }

    private boolean findNodeRoad(TreeNode node, TreeNode p, TreeNode q, TreeNode result) {
        boolean self = false, left = false, right = false;
        if (node.val == p.val || node.val == q.val) {
            self = true;
        }
        if (node.left != null) {
            if (findNodeRoad(node.left, p, q, result)) {
                left = true;
            }
        }

        if (node.right != null) {
            if (findNodeRoad(node.right, p, q, result)) {
                right = true;
            }
        }
        if ((self && left) ||
                (self && right) ||
                (left && right)) {
            result.left = node;
        }
        if (self || left || right) {
            return true;
        }
        return false;
    }
}