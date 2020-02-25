package com.home.work.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_587 {
    public List<Integer> preorder(Node root) {
        //迭代
        // List<Integer> res = new ArrayList<>();
        // Stack<Node> stack = new Stack();
        // if (root == null) return res;
        // stack.add(root);
        // while (!stack.isEmpty()) {
        //     Node n = stack.pop();
        //     res.add(n.val);
        //     if (n.children != null && n.children.size() > 0) {
        //         List<Node> childrens = n.children;
        //         for (int i = childrens.size() - 1; i >= 0 ; i--) {
        //             stack.push(childrens.get(i));
        //         }
        //     }
        // }
        // return res;

        //递归
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null && root.children.size() > 0) {
            for (Node n : root.children) {
                helper(n, res);
            }
        }
    }
}
