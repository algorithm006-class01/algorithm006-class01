/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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
        List<Integer> result = new ArrayList<>();
        traverse(result, root);
        return result;
    }

    private void traverse(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        for (Node child : root.children) {
            traverse(result, child);
        }
    }
}
// @lc code=end
