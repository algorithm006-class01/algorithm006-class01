/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_2_025 {
    /**
     * 迭代方式
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            // 所有的左子树
            while (tmp != null) {
                res.add(tmp.val);
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop().right;
        }
        return res;
    }

    /**
     * 递归方式
     */
    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doPreorderTraversal0(res, root);
        return res;
    }

    private void doPreorderTraversal0(List<Integer> res, TreeNode root) {
        if (root != null) {
            res.add(root.val);
            this.doPreorderTraversal0(res, root.left);
            this.doPreorderTraversal0(res, root.right);
        }
    }
}