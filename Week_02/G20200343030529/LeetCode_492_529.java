package com.leetcode.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode.429.N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * 层级遍历二叉树，采用队列queue
     * 1、根节点入队列
     * 2、判断队列是否为空
     * 3、获取队列大小为n
     * 4、遍历队列前n个元素
     *  4.1、每个元素依次出队列，元素节点值添加到集合中
     *  4.2、每个元素中所有子元素加入队列
     * 5、把集合中结果加入到结果中
     * 6、回到步骤2
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();//广度搜索二叉树，采用queue
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val); //加入当前层级节点值
                queue.addAll(node.children); //加入当前层级节点所有子节点
            }
            result.add(level);
        }
        return result;
    }


    // public List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (root == null) {
    //         return result;
    //     }
    //     helper(root, 0, result);
    //     return result;
    // }
    // //深度搜索中，建立层级关系，在遍历树的同时，先对应层级添加当前节点的值
    // private void helper(Node node, int level, List<List<Integer>> result) {
    //     if (result.size() <= level) {
    //         List<Integer> list = new ArrayList<>();
    //         list.add(node.val);
    //         result.add(list);
    //     } else {
    //         result.get(level).add(node.val);
    //     }
    //     for (Node child : node.children) {
    //         helper(child, level + 1, result);
    //     }
    // }
}
