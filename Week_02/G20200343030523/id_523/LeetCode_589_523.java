package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, result);
            }
        }
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

        NAryTreePreorderTraversal traversal = new NAryTreePreorderTraversal();
        System.out.println(traversal.preorder(root));
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
