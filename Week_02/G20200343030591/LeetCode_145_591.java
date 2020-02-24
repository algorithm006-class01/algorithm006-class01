class Solution {

    /**
     * 二叉树的后序遍历
     * 递归 比较好想
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {

            if (root.left!=null) {
                helper(root.left, res);
            }
            if (root.right!=null) {
                helper(root.right, res);
            }
            res.add(root.val);
        }
    }

    /**
     * 二叉树的后序遍历
     * 迭代法
     * 要想用迭代法 肯定就得用 栈
     * 从 左右根 -> 栈中顺序为 根右左
     * 这样出的时候就可以 根左右 的顺序出栈了
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            res.add(0, node.val);
            if (node.left!=null) {
                stack1.push(node.left);
            }
            if (node.right!=null) {
                stack1.push(node.right);
            }
        }
        return res;
    }











}