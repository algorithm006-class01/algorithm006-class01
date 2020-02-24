import java.util.*;
class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            res.add(pop.val);
            for (int i = pop.children.size() - 1; i >= 0; i--) {
                stack.push(pop.children.get(i));
            }
        }
        return res;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        recurPreorder(root, res);
        return res;
    }

    private void recurPreorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            recurPreorder(node, res);
        }
    }
}
