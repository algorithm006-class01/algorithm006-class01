
class Solution {

    /**
     * 递归
     * 题目：二叉树的最近公共祖先
     * 1、如果根节点为空 或者 根节点 等于 p 或者 根节点 等于 q 那么根节点就是最近公共祖先
     * 2、先到左子树中找
     * 3、再到柚子树中找
     * 4、如果最终 发现left 和 right都不为空 则说明 左右子树都找到了结果 那说明 跟节点 即为公共祖先
     * 5、如果4不满足 则left和right谁为null 则 说明为null的哪一方没有p 和 q 返回不为null的一方即可
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right!=null) return root;

        return left == null ? right : left;
    }

    /**
     * 迭代
     * 国际版解法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }


}