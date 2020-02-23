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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList();
        traverse(root, list);
        return list;
    }

    private void traverse(Node node, List<Integer> list) {
        if (node == null) return;
        if (node.children != null) {
            node.children.forEach(item -> {
                traverse(item, list);
            });
        }
        list.add(node.val);
    }
}