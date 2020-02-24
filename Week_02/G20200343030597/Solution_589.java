import java.util.ArrayList;
import java.util.List;

public class Solution_589 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        charge(root);
        return result;
    }

    private void charge(Node root) {
        if (root == null) return;

        result.add(root.val);
        for (Node node : root.children) {
            charge(node);
        }
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
