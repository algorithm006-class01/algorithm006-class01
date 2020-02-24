class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                parent.put(pop.left, pop);
                stack.push(pop.left);
            }
            if (pop.right != null) {
                parent.put(pop.right, pop);
                stack.push(pop.right);
            }
        }
        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }
        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
