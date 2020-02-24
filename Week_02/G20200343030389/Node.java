package follow.phenix.ice.algorithm.weektwo;

import java.util.List;

class Node {
    int val;
    List<Node> children;

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
