/**
 * 使用栈
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:59
 */
class LeetCode_144_505 {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }

        Stack<TreeNode> stacks = new Stack<TreeNode>();
        stacks.add(root);
        TreeNode curr = null;
        while (!stacks.isEmpty()) {
            curr = stacks.pop();
            result.add(curr.val);
            if(curr.right != null) {
                stacks.add(curr.right);
            }
            if(curr.left != null) {
                stacks.add(curr.left);
            }
        }

        return result;
    }
}

/**
 * 递归方法
 * @author huangwen05
 *
 * @date:   2020年2月23日 下午7:53:48
 */
class LeetCode_144_505_digui {
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTree(root);
        return result;
    }

    public void preorderTree(TreeNode root) {
        if(root == null) {
            return;
        }

        result.add(root.val);
        preorderTree(root.left);
        preorderTree(root.right);
    }
}