public class Solution {
    public List<Integer> preorder(Node root) {
        // return preorderIter(root);
        List<Integer> list = new ArrayList<Integer>();
        postorderRecursion(root, list);

        return list;
    }

    public List<Integer> preorderIter(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            if(node.children == null){
                continue;
            }
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }

        return list;
    }

    public void postorderRecursion(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node each : root.children) {
            postorderRecursion(each, list);
        }
    }

}
