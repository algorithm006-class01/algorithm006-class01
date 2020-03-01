import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_423 {

    public static void main(String[] args) {

//        int[] a = {1, 1, 2};
//        printResult(a);
//
//        int[] b = {0,0,1,1,1,2,2,3,3,4};
//        printResult(b);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class SolutionOne {
    public List<Integer> preorderTraversal(TreeNode root) {
        List res = new ArrayList();
        helper(root ,res);
        return res;
    }

    public void helper(TreeNode root, List res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}