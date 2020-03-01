package com.aizain.jhome.computer.data.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Postorder
 * <p>
 * 590. N叉树的后序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 第一遍：2020/2/23
 *
 * @author Zain
 * @date 2020/2/23
 * @see Preorder
 */
public class Postorder {

    /**
     * 解题思路：
     * 1、递归实现后续遍历
     * 2、迭代法完成此题
     * <p>
     * 前序遍历：根左右
     * 中序遍历：左根右
     * 后序遍历：左右根
     * ps: 前中后指的是根的遍历位置，这样就好记了
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ret = new LinkedList<>();

        // 1 recursion terminator
        if (Objects.isNull(root)) {
            return ret;
        }
        if (Objects.isNull(root.children) || root.children.isEmpty()) {
            ret.add(root.val);
            return ret;
        }

        // 2 process logic in current level

        // 3 drill down
        // 左右根
        for (Node node : root.children) {
            ret.addAll(postorder(node));
        }
        ret.add(root.val);

        // 4 reverse the current level status if needed
        return ret;
    }

    /**
     * 迭代法常见套路，反向顺序处理
     *
     * @param root
     * @return
     */
    public List<Integer> postorderLoop(Node root) {
        LinkedList<Integer> ret = new LinkedList<>();

        // 1 recursion terminator
        if (Objects.isNull(root)) {
            return ret;
        }
        if (Objects.isNull(root.children) || root.children.isEmpty()) {
            ret.add(root.val);
            return ret;
        }

        LinkedList<Node> deque = new LinkedList<>();
        // 左右根 --> 根右左
        deque.push(root);
        while (!deque.isEmpty()) {
            Node current = deque.pollFirst();
            ret.push(current.val);
            for (Node node : current.children) {
                deque.push(node);
            }
        }

        return ret;
    }

}
