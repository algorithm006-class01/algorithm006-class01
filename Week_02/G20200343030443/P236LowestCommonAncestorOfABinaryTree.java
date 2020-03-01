//Java：二叉树的最近公共祖先
public class P236LowestCommonAncestorOfABinaryTree {

  public static void main(String[] args) {
    Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
    // TO TEST
  }


  // Definition for a binary tree node.
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    TreeNode rNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      findLowestCommonAncestor(root, p, q);
      return rNode;
    }

    private int findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
        return 0;
      }
      if (rNode != null) {//找到公共节点后不再遍历
        return 3;
      }
      int findSum = 0;
      if (root == p || root == q) {
        findSum++;
      }
      findSum += findLowestCommonAncestor(root.left, p, q);
      findSum += findLowestCommonAncestor(root.right, p, q);
      if (findSum == 2 && rNode == null) {
        rNode = root;
      }
      return findSum;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)
}
