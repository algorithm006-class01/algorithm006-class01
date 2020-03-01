public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<Node> queue = new LinkedList<Node>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<Integer>();
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                Node poll = queue.poll();
                levelList.add(poll.val);
                if (poll.children != null) {
                    queue.addAll(poll.children);
                }
            }
            list.add(levelList);
        }

        return list;
    }
}
