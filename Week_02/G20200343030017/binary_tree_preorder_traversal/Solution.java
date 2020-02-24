package week2.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root,list);
        return list;
    }
    public void recursion(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        if (root.left!=null){
            recursion(root.left,list);
        }
        if (root.right!=null){
            recursion(root.right,list);
        }
    }
}
