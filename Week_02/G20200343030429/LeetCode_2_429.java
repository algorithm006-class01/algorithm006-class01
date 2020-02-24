package com.study.week02;

import com.study.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Abner
 * @date 2020/2/23 21:15
 * @email songkd90@163.com
 * @description 前序遍历树
 */
public class LeetCode_2_429 {
    /**
     * 解法一：递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 前序遍历  根->左->右 先加入根节点
        list.add(root.val);
        for (Node child : root.children) {
            helper(child, list);
        }
    }

    /**
     * 解法二：迭代
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return list;
    }
}
