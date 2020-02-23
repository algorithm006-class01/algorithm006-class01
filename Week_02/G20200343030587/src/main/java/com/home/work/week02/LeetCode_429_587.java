package com.home.work.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_587 {
    public List<List<Integer>> levelOrder(Node root) {
        //队列广度优先
        // List<List<Integer>> res = new ArrayList<>();
        // LinkedList<Node> queue = new LinkedList<>();
        // queue.offer(root);
        // if (root == null) return res;
        // while (!queue.isEmpty()) {
        //     List<Integer> level = new ArrayList<>();
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         Node node = queue.pop();
        //         level.add(node.val);
        //         if(node.children != null && node.children.size() > 0) {
        //             queue.addAll(node.children);
        //         }
        //     }
        //     res.add(level);
        // }
        // return res;

        //递归实现
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (level + 1 > res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        if (root.children != null) {
            for (Node n : root.children) {
                helper(n, level + 1, res);
            }
        }

    }
}
