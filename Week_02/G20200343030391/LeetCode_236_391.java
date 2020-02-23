package G20200343030391;

public class LeetCode_236_391 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        TreeNode treeNode = lowestCommonAncestor(node3, node5, node1);
        System.out.println(treeNode.val);
    }

    /**
     * 递归： 分别递归左右子树查找p，p;
     * 若同时存在，则祖先为root；
     * 若存在p或q中的
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
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // p q 分别存在于左右子树
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode == null) {//p q 不在左子树
            return rightNode;
        } else {
            return leftNode;
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
