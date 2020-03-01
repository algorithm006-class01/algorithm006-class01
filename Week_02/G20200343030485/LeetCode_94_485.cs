/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        List<int> list = new List<int>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || stack.Count != 0) {
            while (current != null) {
                stack.Push(current);
                current = current.left;
            }

            current = stack.Pop();
            list.Add(current.val);
            current = current.right;
        }

        return list;
    }
}