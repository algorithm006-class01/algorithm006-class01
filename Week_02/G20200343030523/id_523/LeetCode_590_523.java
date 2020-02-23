package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        heler(root, result);
        return result;
    }

    private void heler(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            List<Node> children = node.children;
            for (Node child : children) {
                heler(child, result);
            }
        }
        result.add(node.val);
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

        NAryTreePostorderTraversal traversal = new NAryTreePostorderTraversal();
        System.out.println(traversal.postorder(root));
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

    ;

}
