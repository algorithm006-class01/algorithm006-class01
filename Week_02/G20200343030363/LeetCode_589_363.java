package cn.geek.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月22日 22:39:00
 */
public class LeetCode_589_363 {

    /**
     * Preorder list.
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        conver(root, res);
        return res;
    }

    private void conver(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (null != root.children) {
            for (Node children : root.children) {
                conver(children, res);
            }
        }
    }

    /**
     * Preorder by stack list. 前序 根左右
     *
     * @param root
     *            the root
     * @return the list
     */
    public List<Integer> preorderByStack(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return res;
    }
}
