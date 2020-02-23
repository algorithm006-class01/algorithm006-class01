package cn.geek.week2;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 *
 *
 * 1、递归 2、深度优先 dfs depth first search 3、广度优先
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月21日 10:42:00
 */
public class LeetCode_111_363 {

    /**
     * Min depth int.
     *
     * @param root
     *            the root
     * @return the int
     */
    public int minDepth(TreeNode root) {

        // 1.递归

        // 递归出口
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 1;
        }

        int minDepth = 1;

        if (null != root.left) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }

        if (null != root.right) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /**
     * Min depth by queue int. DFS
     *
     * @param root
     *            the root
     * @return the int
     */
    public int minDepthByDFS(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (null == root) {
            return 0;
        }
        queue.add(new Pair(root, 1));
        int minDepth = 1;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            int currDepth = current.getValue();
            if (root.left == null && root.right == null) {
                minDepth = Math.min(minDepth, currDepth);
            }
            if (root.left != null) {
                queue.add(new Pair(root.left, currDepth + 1));
            }
            if (root.right != null) {
                queue.add(new Pair(root.right, currDepth + 1));
            }
        }
        return minDepth;
    }
}
