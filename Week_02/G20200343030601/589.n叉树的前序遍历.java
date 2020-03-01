import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (72.06%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    18.5K
 * Total Submissions: 25.6K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
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
    // N叉树遍历，在N未知时，没办法谈中序遍历
    // 前序遍历和后序遍历可采用一致的递归套路
    public List<Integer> preorder(Node root) {
        List<Integer> preorderValues = new LinkedList<Integer>();
        preorderRecursion(root, preorderValues);
        return preorderValues;
    }

    private void preorderRecursion(Node node, List<Integer> preorderValues){
        if (null == node){
            return;
        }

        preorderValues.add(node.val);

        for (Node child : node.children) {
            preorderRecursion(child, preorderValues);
        }
    }
}
// @lc code=end

