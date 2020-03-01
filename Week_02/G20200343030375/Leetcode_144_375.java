package G20200343030375;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存消耗 : 37.4 MB , 在所有 Java 提交中击败了 5.19% 的用户
 */

public class Leetcode_144_375 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root != null){
            recur(root,result);
        }
        return result;
    }
    private void recur(TreeNode node,List<Integer> result){
        result.add(node.val);
        if(node.left != null) recur(node.left,result);
        if(node.right != null) recur(node.right,result);
        return;
    }

   private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
}
