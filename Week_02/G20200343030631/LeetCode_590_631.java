package com.dsx.fivehundred.ninety.zero;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 递归方式
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了99.73%的用户
 * 内存消耗: 41.2 MB, 在所有 Java 提交中击败了5.01%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version1 {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root){
            return result;
        }
        postOrderInternal(root, result);
        return result;
    }

    private void postOrderInternal(Node root, List<Integer> result) {
        if (null == root){
            return;
        }
        List<Node> children = root.children;
        for (Node child : children) {
            postOrderInternal(child, result);
        }
        result.add(root.val);
    }

    // Definition for a Node.
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


package com.dsx.fivehundred.ninety.zero;

        import java.util.*;
/**
 * 解题思路: 迭代方式
 * 时间复杂度: O(nk) n是节点总数，k是节点的最大子节点数目
 * 空间复杂度: O(n)
 * 执行用时: 10 ms, 在所有 Java 提交中击败了5.85%的用户
 * 内存消耗: 41.5 MB, 在所有 Java 提交中击败了5.01%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> subTree1 = new LinkedList<>();
        subTree1.add(node3);
        subTree1.add(node2);
        subTree1.add(node4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> subTree2 = new LinkedList<>();
        subTree2.add(node5);
        subTree2.add(node6);
        node3.children = subTree2;
        root.children = subTree1;
        List<Integer> result = postorder(root);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<Node> nodeTraverStack = new Stack<>();
        Map<Node, Integer> nodeRecord = new HashMap<>();
        nodeTraverStack.add(root);
        while (!nodeTraverStack.isEmpty()) {
            Node tmpNode = nodeTraverStack.peek();
            if (!nodeRecord.keySet().contains(tmpNode) && null != tmpNode.children) {
                nodeRecord.put(tmpNode, 1);
                List<Node> children = tmpNode.children;
                for (int i = (children.size() - 1); i >= 0; i--) {
                    nodeTraverStack.add(children.get(i));
                }
            } else {
                result.add(tmpNode.val);
                nodeTraverStack.pop();
            }

        }
        return result;
    }

    // Definition for a Node.
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


package com.dsx.fivehundred.ninety.zero;

        import java.util.*;

/**
 * 解题思路: 迭代方式，参考官方解答简约版本，使用的是双端队列
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 10 ms, 在所有 Java 提交中击败了5.85%的用户
 * 内存消耗: 41.5 MB, 在所有 Java 提交中击败了5.01%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version3 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> subTree1 = new LinkedList<>();
        subTree1.add(node3);
        subTree1.add(node2);
        subTree1.add(node4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> subTree2 = new LinkedList<>();
        subTree2.add(node5);
        subTree2.add(node6);
        node3.children = subTree2;
        root.children = subTree1;
        List<Integer> result = postorder(root);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node tmpNode = stack.pollLast();
            result.addFirst(tmpNode.val);
            if (null != tmpNode.children){
                for (Node child : tmpNode.children) {
                    if (null != child){
                        stack.add(child);
                    }
                }
            }
        }
        return result;
    }

    // Definition for a Node.
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