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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        traverse(result, q);
        return result;
    }

    private void traverse(List<List<Integer>> result, Queue<Node> q) {
        // Stop condition
        if(q.size() == 0) {
            return;
        }

        // Process current level
        int levelSize = q.size();

        List<Integer> level = new ArrayList<>();
        for(int i = 0; i < levelSize; i++) {
            Node node = q.poll();
            level.add(node.val);
            for(Node child : node.children) {
                q.offer(child);
            }
        }
        result.add(level);
        
        // Dig into deeper level
        traverse(result, q);
    }
}