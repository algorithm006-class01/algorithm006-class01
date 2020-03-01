//二叉树前序遍历


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // //方法一：递归
    // List<Integer> result = new ArrayList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if (root == null){
    //         return result;
    //     }

    //     result.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);

    //     return result;
    // }


    // 方法二：迭代 时间复杂度O(N) 空间复杂度O(N)
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null){
            return output;
        }

        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pollLast();
            output.add(treeNode.val);

            if (treeNode.right != null){
                stack.add(treeNode.right);
            }
            
            if (treeNode.left != null){
                stack.add(treeNode.left);
            }
        }

        return output;
    }

}