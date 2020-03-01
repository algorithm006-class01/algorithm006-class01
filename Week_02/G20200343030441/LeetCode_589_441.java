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
    public List<Integer> preorder_list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        _preorder(root);
        return preorder_list;
    }
    private void _preorder(Node current_node){
        if (current_node == null) return;

        preorder_list.add(current_node.val);

        for (Node n: current_node.children){
            _preorder(n);
        }
    }
}
// @lc code=end

