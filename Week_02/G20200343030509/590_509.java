import java.util.LinkedList;
import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    // 递归
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder (Node root) {
        // terminator
        if(root == null) { 
            return list;
        }

        // drill down
        for( Node node: root.children) {
            postorder(node);
        }

        // process current logic
        list.add(root.val);

        return list;
    }

    //迭代
    public List<Integer> postorder2 (Node root) {
        LinkedList<Integer> l = new LinkedList<>();

        if (root == null) return l;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            l.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }

        return l;
    }




    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.postorder(""));
    }
}

