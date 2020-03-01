/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
import java.util.*;

class Solution_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> nodeVals = new HashSet();
        nodeVals.add(p.val);
        nodeVals.add(q.val);
        TreeNode[] resultPlaceholder = new TreeNode[1];
        findNodes(root, nodeVals, resultPlaceholder);
        return resultPlaceholder[0];
    }

    private void findNodes(TreeNode root, Set<Integer> nodeVals, TreeNode[] resultPlaceholder) {
        if (root == null) {
            return;
        }
        int initialSize = nodeVals.size();
        findNodes(root.left, nodeVals, resultPlaceholder);
        findNodes(root.right, nodeVals, resultPlaceholder);
        boolean case1 = initialSize == 2 && nodeVals.size() == 0; // 两个节点分别在左右子树的情况
        nodeVals.remove(root.val);
        boolean case2 = initialSize == 2 && !case1 && nodeVals.size() == 0; // 其中一个节点就是子树根节点的情况

        if ((case1 || case2) && resultPlaceholder[0] == null) {
            resultPlaceholder[0] = root;
        }
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
// @lc code=end
