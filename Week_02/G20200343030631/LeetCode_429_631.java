package com.dsx.fourhundred.twenty.nine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 解题思路: 使用队列，每次出队一个节点，记录值，然后如果有子节点则将当前节点子节点全部入队
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 3 ms, 在所有 Java 提交中击败了79.55%的用户
 * 内存消耗: 41.7 MB, 在所有 Java 提交中击败了9.52%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version1 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<Node> leverOrderAssit = new LinkedList<>();
        leverOrderAssit.add(root);
        while (!leverOrderAssit.isEmpty()){
            // 当前层的值记录
            List<Integer> currentLevel = new ArrayList<>();
            // 记录当前层共有几个节点
            int size = leverOrderAssit.size();
            for (int i = 0; i < size; i++) {
                Node node = leverOrderAssit.poll();
                currentLevel.add(node.val);
                leverOrderAssit.addAll(node.children);
            }
            result.add(currentLevel);
        }
        return result;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
