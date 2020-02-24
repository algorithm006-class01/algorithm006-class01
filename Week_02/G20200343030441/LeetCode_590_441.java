import java.util.List;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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

    public List<Integer> postorder_list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        _postorder(root);
        return postorder_list;
    }

    private void _postorder(Node current_node){
        if (current_node == null) return;

        for (Node n: current_node.children){
            _postorder(n);
        }
        postorder_list.add(current_node.val);
    }
}
// @lc code=end

