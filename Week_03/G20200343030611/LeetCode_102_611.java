package datast.bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_102_611 {

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(0, res, root);
        return res;
    }

    private void helper(int level, List<List<Integer>> res, TreeNode node) {
        if (level == res.size()) {
            res.add(new ArrayList());
        }
        res.get(level).add(node.val);
        if (node.left != null) {
            helper(level + 1, res, node.left);
        }
        if (node.right != null) {
            helper(level + 1, res, node.right);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
