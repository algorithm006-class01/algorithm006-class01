package G20200343030391;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_145_391 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        node4.right = node5;
        node5.right = node6;
        List<Integer> integers = postorderTraversallByLoop(node1);
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
     * 循环遍历：stack 保存未访问节点，node保存当前指向的节点（为空代表左子树到头），last代表上次访问的最后节点，栈顶元素右子树不为空
     * 遍历右子树；上次循环最后访问节点！=栈顶元素右节点代表栈顶
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversallByLoop(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.peek();
                if (pop.right != null && pop.right != last) {
                    node = pop.right;
                } else {
                    list.add(pop.val);
                    last = pop;
                    stack.pop();
                }
            }
        }
        return list;
    }

    /**
     * 递归遍历：递归查找最左节点，右节点,根节点
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalByRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public static void recursion(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            recursion(node.left, list);
            recursion(node.right, list);
            list.add(node.val);
        }
    }
}
