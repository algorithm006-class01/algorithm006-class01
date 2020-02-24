public class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> list = new LinkedList<Integer>();

        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pollLast();
            list.addFirst(currentNode.val);
            for (Node each: currentNode.children) {
                if (each != null) {
                    stack.add(each);
                }
            }
        }

        return list;
    }
}
