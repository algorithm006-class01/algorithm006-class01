package com.home.work.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144_587 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //递归
        // List<Integer> res = new ArrayList<>();
        // helper(root, res);
        // return res;

        //迭代
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) helper(root.left, res);
        if (root.right != null) helper(root.right, res);
    }
}
