package G20200343030391;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_429_391 {

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
        List<List<Integer>> postorder = levelOrderByLoop(node1);
        System.out.println(postorder);
    }

    /**
     * 深度优先：子节点全部加入队列，队列当前长度即为当前从层的元素个数
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderByLoop(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderByRecursion(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        recursion(root, 0, result);
        return result;
    }

    public static void recursion(Node node, int level, List<List<Integer>> list) {
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        for (Node child : node.children) {
            recursion(child, level + 1, list);
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
