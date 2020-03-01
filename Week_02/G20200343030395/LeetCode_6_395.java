package Week_02.G20200343030395;

public class LeetCode_6_395 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //节点为空，直接返回
        if(root == null) {
            return root;
        }

        //是自己的时候直接返回自己
        if(root == p || root == q) {
            return root;
        }

        //左右递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //都不空的时候返回自己，就是祖先；其他的谁不空返回谁
        if(left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }

        return null;
    }
}
