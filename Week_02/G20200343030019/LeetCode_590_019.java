class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();
        if (root == null) {
            return result;
        }

        stack.add(root);
        Node node = null;
        while (!stack.isEmpty()) {
            node = stack.pollLast();
            result.addFirst(node.val);

            for(Node n: node.children) {
                if (n != null) {
                    stack.add(n);
                }
            }
        }
        return result;
    }
}