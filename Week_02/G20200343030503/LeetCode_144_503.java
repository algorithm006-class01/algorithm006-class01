/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 二叉树的前序遍历
 * 使用递归 从根节点开始遍历,如果是根节点直接添加到结果的集合中,如果是左节点继续递归,同理有节点一样
 * 
 * 借助栈 
 * LinkedList 是一个双向链表。
 * 它也可以被当作堆栈、队列或双端队列进行操作。LinkedList随机访问效率低，但随机插入、随机删除效率低。
 * 总结: 本题中LinkedList比stack快
 *
 */
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<Integer>();
//         helper(root,result);
//         return result;
//     }

//     public void helper(TreeNode root,List<Integer> result) {
//         if (root != null ) {
//             result.add(root.val);
//             if (root.left != null) {
//                 helper(root.left,result);
//             }   
//             if (root.right != null) {
//                 helper(root.right,result);
//             }
//         }
//     }
// }
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        //先序遍历 先把根节点入栈
        //stack.push(root);
        stack.add(root);
        while (!stack.isEmpty()) { //栈不为空的时候
            //根节点出栈
            //TreeNode treeNode = stack.pop();
            TreeNode treeNode = stack.pollLast();
       
            result.add(treeNode.val);
            //先入右节点
            //再入左节点
            if (treeNode.right != null) {
                //stack.push(treeNode.right);
                stack.add(treeNode.right);
            }
            if (treeNode.left != null) {
                //stack.push(treeNode.left);
                stack.add(treeNode.left);
            }
        }

        return result;

    }
}