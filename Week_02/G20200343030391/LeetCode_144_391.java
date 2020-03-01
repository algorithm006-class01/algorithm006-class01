package G20200343030391;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144_391 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        List<Integer> integers = preorderTraversalByRecursion(node1);
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
     * 循环遍历：stack 保存根节点，先访问根节点，然后循环左子树，为空则循环右子树
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalByLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }
        return result;
    }

    /**
     * 递归遍历：递归查找最左节点，根节点，右节点
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversalByRecursion(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public static void recursion(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            list.add(node.val);
            recursion(node.left, list);
            recursion(node.right, list);
        }
    }
}
