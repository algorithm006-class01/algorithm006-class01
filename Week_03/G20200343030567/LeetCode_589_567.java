package com.aizain.jhome.computer.data.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Preorder
 * 589. N叉树的前序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 第一遍：2020/2/23
 *
 * @author Zain
 * @date 2020/2/23
 * @see Postorder
 */
public class Preorder {

    /**
     * 解题思路：
     * 1、递归实现前续遍历
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
    public List<Integer> preorder(Node root) {
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
        // 根左右
        ret.add(root.val);
        for (Node node : root.children) {
            ret.addAll(preorder(node));
        }

        // 4 reverse the current level status if needed
        return ret;
    }

}
