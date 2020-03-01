import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer> ();
        preOrder(root, ans);
        return ans;
    }

    public void preOrder(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        if (root.children.size() == 0) return;
        for (Node child : root.children) 
            preOrder(child, ans);
    }
}
// @lc code=end

