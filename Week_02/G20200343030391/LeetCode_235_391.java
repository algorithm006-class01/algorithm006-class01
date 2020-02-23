package G20200343030391;

public class LeetCode_235_391 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        node6.left = node2;
        node2.left = node9;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;
        TreeNode treeNode = lowestCommonAncestor(node6, node2, node8);
        System.out.println(treeNode.val);
    }

    /**
     * 递归：
     * 1.p q 同时小于根节点，则p q 祖先在左子树
     * 2.p q 同时大于根节点，则p q 祖先在右子树
     * 3.p q 位于根节点两侧，则root 为根节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
