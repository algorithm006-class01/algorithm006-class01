package cn.geek.week2;

/**
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月22日 10:12:00
 */
public class LeetCode_236_363 {

    /**
     * Lowest common ancestor tree node.
     *
     * @param curr
     *            the curr
     * @param p
     *            the p
     * @param q
     *            the q
     * @return the tree node
     */
    public TreeNode lowestCommonAncestor(TreeNode curr, TreeNode p, TreeNode q) {
        if (null == curr || curr == p || curr == q) {
            return curr;
        }
        TreeNode left = lowestCommonAncestor(curr.left, p, q);
        TreeNode right = lowestCommonAncestor(curr.right, p, q);
        if (left != null && right != null) {
            return curr;
        }
        return left == null ? right : left;
    }
}
