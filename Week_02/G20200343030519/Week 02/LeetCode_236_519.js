// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

var lowestCommonAncestor = function(root, p, q) {
    if (root == null || root == p || root == q) {
        return root;
    }
    let left = lowestCommonAncestor(root.left, p, q);
    let right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
        return root;
    }
    return left != null ? left : right;
}