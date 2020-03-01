package G20200343030015.week_02;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_589_015 {

    /**
     * 先向栈中添加元素，然后逆序添加元素信息
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return new LinkedList<Integer>();
        List<Integer> output = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<Node>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            output.add(tmpNode.val);

            for (int i = tmpNode.children.size() - 1; i >= 0; i--) {
                if (tmpNode.children.get(i) != null) {
                    stack.push(tmpNode.children.get(i));
                }
            }
        }

        return output;
    }
}
