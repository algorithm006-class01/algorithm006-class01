import java.util.List;
import java.util.Vector;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (72.20%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    16.2K
 * Total Submissions: 22.5K
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
    // 树的遍历首先考虑递归解决，递归的套路代码结构：
    // 1. Terminator
    // 2. Current level logic
    // 3. Drill down
    // 4. Reverse
    public List<Integer> postorder(Node root) {
        List<Integer> postValues = new LinkedList<Integer>();
        postorderRecursion(root, postValues);
        return postValues;
    }

    private void postorderRecursion(Node node, List<Integer> postValues){
        if (null == node) {
            return;
        }
        
        // 优先遍历各子树
        for (Node child : node.children) {
            postorderRecursion(child, postValues);
        }

        postValues.add(node.val);
    }

    /*
    // 同样的思路，函数实现稍微变动（不额外增加迭代函数）
    // 但频繁的开辟新List，消耗大
    public List<Integer> postorder(Node root) {
        List<Integer> postValues = new LinkedList<Integer>();
        if (null == root) {
            return postValues;
        }

        for (Node child : root.children) {
            postValues.addAll(postorder(child));
        }

        postValues.add(root.val);

        return postValues;
    }
    */
}
// @lc code=end

