package G20200343030535;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_589_535 {

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
    }

    List<Integer> res=new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }
    public void helper(Node root){
        if (root == null) return;
        res.add(root.val);
        for (int i = 0; i <root.children.size() ; i++) {
            helper(root.children.get(i));
        }
    }


}
