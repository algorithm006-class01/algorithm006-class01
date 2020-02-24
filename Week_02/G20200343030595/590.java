// 这一题 Leetcode 上不支持 Go，所以就用 java 写了
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
       if (root == null)
           return list;

       for ( Node n: root.children) {
           postorder(n);
       }

       list.add(root.val);

       return list;
    }
}