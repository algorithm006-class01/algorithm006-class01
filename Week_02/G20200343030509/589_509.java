/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

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

    public List<Integer> preorder(Node root) {
        if (root == null) return list;

        list.add(root.val);

        for (Node child: root.children) { 
            preorder(child);
        }

        return list;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
    
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            List<Node> nodeList = node.children;
            for (int i = nodeList.size() -1; i >=0; i-- ) {
                stack.push(nodeList.get(i));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.preorder(""));
    }
}

