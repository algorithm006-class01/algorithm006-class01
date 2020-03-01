package cn.geek.week2;

import java.util.Stack;

/**
 * 验证二叉搜索树
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月20日 11:25:00
 */
public class LeetCode_098_363 {

    /**
     * Is valid bst boolean.
     *
     * @param root
     *            the root
     * @return the boolean
     */
    public boolean isValidBST(TreeNode root) {

        return valid(root, null, null);
    }

    /**
     * Valid boolean.
     *
     * @param root
     *            the root
     * @param max
     *            the max
     * @param min
     *            the min
     * @return the boolean
     */
    private boolean valid(TreeNode root, Integer max, Integer min) {
        if (null == root) {
            return true;
        }

        // 当前层逻辑
        if (max != null && root.val >= max) {
            return false;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (!valid(root.left, root.val, min)) {
            return false;
        }

        if (!valid(root.right, max, root.val)) {
            return false;
        }
        return true;
    }

    /**
     * Valid by stack boolean.
     *
     * @param root
     *            the root
     * @return the boolean
     */
    public boolean validByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_098_363 leetcode = new LeetCode_098_363();

    }
}
