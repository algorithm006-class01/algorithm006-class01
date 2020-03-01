class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();

        if (root == null) {
            return result;
        }

        stack.add(root);
        Node node = null;
        while (!stack.isEmpty()) {
            node = stack.poll();
            result.add(node.val);
            for (int index = node.children.size() - 1; index >= 0; index --) {
                if (node.children.get(index) != null) {
                    stack.addFirst(node.children.get(index));
                }
            }
        }
        return result;
    }
}