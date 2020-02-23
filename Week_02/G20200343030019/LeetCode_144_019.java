class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList();
        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();

        stack.add(root);
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node = stack.poll();
            result.add(node.val);
            if (node.right != null) stack.addFirst(node.right);
            if (node.left != null) stack.addFirst(node.left);
        }
        return result;
    }
}