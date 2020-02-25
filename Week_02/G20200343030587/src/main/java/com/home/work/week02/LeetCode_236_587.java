package com.home.work.week02;

public class LeetCode_236_587 {
    //分为二种情况 : p,q 在同一个树中,或p,q 在不同树中
    //递归结束条件 root == null || root == p || root == q
    //递归左树和右树:
    // 1.left && right 不为null 不在同一个树中，root  为公共祖先
    // 2.left || right 为null 在同一个树中 最先找的节点为公共祖先

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //方案一：递归
        // root == null || root == p || root == q，root == null 为找到匹配，
        // root == p || root == q  找到匹配 返回 root
        // 分别递归root左右树 结果 ：left right
        // left != null && right != null root 为公共祖先。
        // left == null 公共祖先只能在 right中
        // right == null  反之 left==null
        // 效率问题 如果，结果在左树种 右树需要递归 （剪枝改善）

        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        //剪枝
        // 1.left 不为null时,判断(left != p && left != q)
        //    即找到结果->left,不需要在遍历右树
        if (left != null && left != p && left != q) return left;

        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
