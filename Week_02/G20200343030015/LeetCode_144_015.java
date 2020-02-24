package G20200343030015.week_02;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_144_015 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeVals = new LinkedList<Integer>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        while (nodes.size() > 0 || root != null) {
            if (root != null) {
                nodeVals.add(root.val);
                nodes.push(root);
                root = root.left;
            } else {
                root = nodes.pop().right;
            }

        }
        return nodeVals;
    }
}
