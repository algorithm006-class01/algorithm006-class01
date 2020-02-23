package G20200343030379;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//94. 二叉树的中序遍历
public class LeetCode_94_379 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //2、基于栈的遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack();
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur=cur.right;

        }

        return res;
    }
    //1、递归法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root!=null){
            if (root.left != null) {
                helper(root.left,list);
            }
            list.add(root.val);
            if (root.right != null) {
                helper(root.right,list);
            }
        }
    }


    public static void main(String[] args) {

    }
}
