package jc.demo.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
public class LeetCode_589_559 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            for(int i = node.children.size()-1;i>=0;i--){
                stack.add(node.children.get(i));
            }
        }
        return list;
    }
}
