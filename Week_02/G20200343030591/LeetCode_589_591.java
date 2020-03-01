class Solution {

    /**
     * N叉树的前序遍历
     * 递归 比较好想
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root!=null) {
            res.add(root.val);
            if (root.children!=null) {
                for (Node node : root.children) {
                    helper(node, res);
                }
            }
        }
    }

    /**
     * N叉树的前序遍历
     * 迭代法
     * 要想用迭代法 肯定就得用 栈
     * 从 根左右 -> 右左根
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }











}