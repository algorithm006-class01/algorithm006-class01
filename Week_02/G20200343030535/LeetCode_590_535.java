package G20200343030535;

import G20200343030535.LeetCode_589_535;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_590_535 {

    class Node {
        public int val;
        public List<LeetCode_589_535.Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<LeetCode_589_535.Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //递归：
    public List<Integer> postorder(LeetCode_589_535.Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(root,res);
        return res;
    }

    private void helper(LeetCode_589_535.Node root, List<Integer> res) {
        if(root == null) return;
        for(LeetCode_589_535.Node node : root.children){
            helper(node,res);
        }
        res.add(root.val);
    }


}
