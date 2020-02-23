package G20200343030391;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_391 {

    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        node1.children = new ArrayList<Node>() {{
            add(node3);
            add(node2);
            add(node4);
        }};
        node3.children = new ArrayList<Node>() {{
            add(node5);
            add(node6);
        }};
        List<Integer> postorder = postorderByLoop(node1);
        System.out.println(postorder);
    }

    /**
     * 循环遍历：子节点不为空，倒叙遍历子节点，加入栈；子节点为空，且为取值循环步骤，当前节点的最后一个子节点！=上次遍历最后节点，取值加入结果集，
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderByLoop(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node last = null;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.peek();
            if (node.children.size() > 0 && node.children.get(node.children.size() - 1) != last) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.add(node.children.get(i));
                }
            } else {
                result.add(node.val);
                stack.pop();
                last = node;
            }
        }
        return result;
    }

    public static List<Integer> postorderByRecursion(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public static void recursion(Node node, ArrayList<Integer> list) {
        if (node != null) {
            for (Node child : node.children) {
                recursion(child, list);
            }
            list.add(node.val);
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
