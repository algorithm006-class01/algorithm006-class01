package com.study.week02;

import com.study.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Abner
 * @date 2020/2/23 21:15
 * @email songkd90@163.com
 * @description 后序遍历树
 */
public class LeetCode_1_429 {

    // 解法1 递归 （题目不建议使用递归）
    // 后序遍历，顺序为左 -> 右 -> 根
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node root, List<Integer> list) {
        // 1 terminator
        if (root == null) {
            return;
        }
        // 2 current

        // 3 drill down
        for (Node child : root.children) {
            helper(child, list);
        }
        // 待左右子节点添加完后，添加根节点
        list.add(root.val);
        // 4 restore
    }

    // 2 迭代法， 利用栈的FILO先进后出特性
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            // 如果无子节点，或子节点包含有前节点
            if ((cur.children.size() == 0) || (pre != null && cur.children.contains(pre))) {
                list.add(cur.val);
                stack.pop();
                pre = cur;
            } else { // 如果有子节点，倒序将子节点压入栈
                List<Node> children = cur.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }

}


