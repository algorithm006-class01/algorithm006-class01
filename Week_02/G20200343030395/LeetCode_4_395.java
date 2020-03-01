package Week_02.G20200343030395;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_4_395 {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }

        list.add(root.val);

        preorderTraversal(root.left);

        preorderTraversal(root.right);

        return list;
    }
}


