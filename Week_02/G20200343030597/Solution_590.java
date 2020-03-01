import java.util.ArrayList;
import java.util.List;

public class Solution_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        each(root,result);
        return result;
    }

    public void each(Node root, List<Integer> result){
        if (root == null) {
            return;
        }

        for (int i=0; i < root.children.size() ;i++) {
            each(root.children.get(i),result);
        }
        result.add(root.val);
    }


}

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