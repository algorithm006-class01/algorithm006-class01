class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> result = new ArrayList();
        traversal(1, root, result);
        return result;
    }

    private void traversal(int layer, Node node, List<List<Integer>> list) {
        if (node == null) return;
        if (layer > list.size()) {
            list.add(new ArrayList());
        }
        list.get(layer - 1).add(node.val);
        for (Node n: node.children) {
            traversal(layer + 1, n, list);
        }
    }
}