package G20200343030379;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//589. N叉树的前序遍历
public class LeetCode_589_379 {

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
    //1、使用栈处理
    public List<Integer> postorder(LeetCode_590_379.Node root) {
        LinkedList<LeetCode_590_379.Node> statck=new LinkedList();
        LinkedList<Integer> res=new LinkedList();
        statck.add(root);
        while (!statck.isEmpty()){
            LeetCode_590_379.Node node = statck.pollLast();
            res.add(node.val);

            Collections.reverse(node.children);
            for (LeetCode_590_379.Node child : node.children) {
                if(child!=null){
                    statck.add(child);
                }
            }
        }
        return res;
    }
    //1、使用栈处理
    public List<Integer> preorder2(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        //空树也是树的一种
        if(root==null){
            return res;
        }

        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            //
            res.addFirst(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                if(child!=null){
                    stack.add(child);
                }
            }
        }
        return res;
    }
    //2、递归法
    public List<Integer> preorder(Node root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        res.add(root.val);
        for (Node child : root.children) {
            if(child!=null){
                helper(child,res);
            }
        }

    }


    public static void main(String[] args) {

    }
}
