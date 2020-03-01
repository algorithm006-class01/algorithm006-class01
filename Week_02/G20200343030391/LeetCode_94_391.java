package G20200343030391;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94_391 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> integers = inorderTraversalByRecursion(node1);
        System.out.println(integers);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 循环遍历：stack 保存根节点，内存循环查找最左节点
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalByLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    /**
     * 递归遍历：递归查找最左节点，根节点，右节点
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalByRecursion(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        recursion(root, list);
        return list;
    }

    public static void recursion(TreeNode node, LinkedList<Integer> list) {
        if (node != null) {
            recursion(node.left, list);
            list.add(node.val);
            recursion(node.right, list);
        }
    }
}
