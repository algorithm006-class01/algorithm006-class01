class Solution {

    /**
     * 二叉树的前序遍历
     * 递归 比较好想
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left!=null) {
                helper(root.left, res);
            }
            if (root.right!=null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 二叉树的前序遍历
     * 迭代法
     * 要想用迭代法 肯定就得用 栈
     * 从 根左右 -> 栈中顺序为 右左根
     * 这样出的时候就可以 根左右 的顺序出栈了
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 使用链表更加灵活 头和尾插入的时间复杂度为O(1)
        List<Integer> res = new LinkedList<>();

        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right!=null) {
                stack.push(node.right);
            }

            if (node.left!=null) {
                stack.push(node.left);
            }

        }
        return res;
    }











}