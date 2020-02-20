import java.util.*;

class Solution {
    //前序遍历倒置
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            res.add(0, pop.val);
            for (Node node : pop.children) {
                stack.push(node);
            }
        }
        return res;
    }

    //递归
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderRecur(root, res);
        return res;
    }

    private void postorderRecur(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        for (Node node : children) {
            postorderRecur(node, res);
        }
        res.add(root.val);
    }
}
