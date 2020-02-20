package G20200343030391;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_391 {

    public static void main(String[] args) {
        Node node1 = new Node(1,new ArrayList<>());
        Node node2 = new Node(2,new ArrayList<>());
        Node node3 = new Node(3,new ArrayList<>());
        Node node4 = new Node(4,new ArrayList<>());
        Node node5 = new Node(5,new ArrayList<>());
        Node node6 = new Node(6,new ArrayList<>());
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

    public static List<Integer> postorderByLoop(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        stack.push(node);
        while (!node.children.isEmpty()) {
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
            node = stack.peek();
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
        }
        return result;
    }

    public static List<Integer> postorderByRecursion(Node root) {
        return null;
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
