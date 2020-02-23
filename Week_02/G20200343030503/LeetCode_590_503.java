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
*
* 递归实现N叉树的遍历 
*/
class Solution {
    List<Integer> result = new ArrayList<Integer>();
    //递归实现
    public List<Integer> postorder(Node root) {
        
        if (root == null) {
            return  null;
        }
        for (Node node: root.children) {
            
            postorder(node);
            
        }
        result.add(root.val); 

        return result;
    }

    //迭代实现
    // public List<Integer> postorder(Node root) {
        
    // }
}