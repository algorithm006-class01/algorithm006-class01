class LeetCode_429_505 {
    private List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return result;
        }

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            while (count-- > 0) {
                Node node = queue.pollFirst();
                level.add(node.val);
                if (node.children != null) {
                    for (Node node1:node.children) {
                        queue.addLast(node1);
                    }
                }
            }

            result.add(level);
        }

        return result;
    }
}