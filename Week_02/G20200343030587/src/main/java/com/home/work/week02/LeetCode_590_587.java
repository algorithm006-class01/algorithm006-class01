package com.home.work.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_587 {
    public List<Integer> postorder(Node root) {
        //递归
        // List<Integer> res = new ArrayList<>();
        // helper(root, res);
        // return res;

        //迭代
        // 后序［左右根］，前序［根左右］
        // 把前序变为［根右左,根右左］反转后既得［左右根，左右根］
        // LinkedList<Integer> res = new LinkedList<>();
        // Stack<Node> stack = new Stack();
        // if (root == null) return res;
        // stack.add(root);
        // while (!stack.isEmpty()) {
        //     Node n = stack.pop();
        //     res.addFirst(n.val);//双向链表 存储时候直接反转结果
        //     if (n.children != null && n.children.size() > 0) {
        //         for (Node node : n.children) {
        //             stack.push(node);
        //         }
        //     }
        // }
        // return res;

        //双栈法
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack();
        Stack<Integer> stack2 = new Stack();//存储结果,遍历输出就是结果
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            stack2.push(n.val);//根－左－右 直接进值栈
            if (n.children != null && n.children.size() > 0) {
                //入栈  左－右
                for (Node node : n.children) {
                    stack.push(node);
                }
            }
        }
        //遍历输出结果
        while (!stack2.isEmpty()) {
            res.add(stack2.pop());
        }
        return res;
    }


    void helper(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node node : root.children) {
            helper(node, res);
        }
        res.add(root.val);
    }
}
