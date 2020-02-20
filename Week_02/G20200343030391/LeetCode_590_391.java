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
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //前指针
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if ((cur.children.size() == 0) || (pre != null && cur.children.contains(pre))) {
                //加入结果集
                res.add(cur.val);
                stack.pop();
                //更新pre指针
                pre = cur;
            } else {
                //继续压栈，注意压栈是从右往左
                List<Node> nodeList = cur.children;
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    stack.push(nodeList.get(i));
                }
            }
        }
        return res;
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
