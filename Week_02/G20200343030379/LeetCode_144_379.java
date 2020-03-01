package G20200343030379;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144. 二叉树的前序遍历
public class LeetCode_144_379 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //1、递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                helper(root.left,list);
            }
            if (root.right != null) {
                helper(root.right,list);
            }
        }
    }


    public static void main(String[] args) {

    }
}
