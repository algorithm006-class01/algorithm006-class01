import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (71.27%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    16.2K
 * Total Submissions: 22.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/*
// Definition for a Node.
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
*/
class Solution {
    public static List<Integer> res = new ArrayList<>();
    public static List<Integer> postorder(Node root) {
      
        if (root == null) {
            return res;
        }
        for (Node c : root.children) {
            postorder(c);
        }
        res.add(root.val);
        return res;

    }

    public static List<Integer> postorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val); 
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
// @lc code=end

