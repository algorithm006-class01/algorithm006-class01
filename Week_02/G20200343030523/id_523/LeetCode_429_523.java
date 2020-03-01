package tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal01 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);

        List<Node> c1 = new ArrayList<>();
        c1.add(n1);
        c1.add(n2);
        c1.add(n3);
        root.children = c1;

        List<Node> c2 = new ArrayList<>();
        c2.add(n4);
        c2.add(n5);
        n1.children = c2;

        NAryTreeLevelOrderTraversal01 orderTraversal = new NAryTreeLevelOrderTraversal01();
        System.out.println(orderTraversal.levelOrder(root));
    }


    static class Node {
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
