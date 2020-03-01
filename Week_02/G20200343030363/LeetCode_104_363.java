package cn.geek.week2;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * 二叉树的最大深度 DFS Depth First Search 深度优先搜索
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月21日 09:54:00
 */
public class LeetCode_104_363 {

    /**
     * Max depth int.
     *
     * @param root
     *            the root
     * @return the int
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Max depth by queue int.
     *
     * @param root
     *            the root
     * @return the int
     */
    public int maxDepthByQueue(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair(root, 1));
        }
        int maxDepth = 1;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            root = curr.getKey();
            int currDepth = curr.getValue();

            if (null != root) {
                maxDepth = Math.max(maxDepth, currDepth);
                queue.add(new Pair(root.left, currDepth + 1));
                queue.add(new Pair(root.right, currDepth + 1));
            }
        }
        return maxDepth;
    }

}
