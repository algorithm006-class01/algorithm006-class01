class Solution {

    /**
     * 二叉树的中序遍历
     * 递归 比较好想
     * @param root
     * @return
     */
     public List < Integer > inorderTraversal(TreeNode root) {
         List < Integer > res = new ArrayList < > ();
         helper(root, res);
         return res;
     }

     public void helper(TreeNode root, List < Integer > res) {
         if (root != null) {
             if (root.left != null) {
                 helper(root.left, res);
             }
             res.add(root.val);
             if (root.right != null) {
                 helper(root.right, res);
             }
         }
     }

    /**
     * 二叉树的中序遍历
     * 迭代法
     * 要想用迭代法 肯定就得用 栈
     * 从 左根右 -> 栈中顺序为 右根左
     * 这样出的时候就可以 左根右 的顺序出栈了
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 使用链表更加灵活 头和尾插入的时间复杂度为O(1)
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        TreeNode current = root;
        while (!stack.isEmpty() || current!=null) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }

}