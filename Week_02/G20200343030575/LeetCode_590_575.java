/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Set<Node> visitedNode = new HashSet<>();
        if(root == null){
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(stack.isEmpty() == false){
            Node node = stack.peek();
            if(node.children.size() == 0 || visitedNode.contains(node)){
                result.add(node.val);
                stack.pop();
            }else{
                visitedNode.add(node);
                for(int i = node.children.size() - 1; i >= 0; i--){
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

}
// @lc code=end

