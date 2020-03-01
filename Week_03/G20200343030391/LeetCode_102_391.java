package G20200343030391;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_102_391 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        node4.right = node5;
        node5.right = node6;
        node5.left = node7;
        List<List<Integer>> lists = new LeetCode_102_391().levelOrderByRecursion(node1);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrderByRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        help(result, root, 0);
        return result;
    }

    private void help(List<List<Integer>> result, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new LinkedList<>());
        }
        result.get(depth).add(root.val);
        help(result, root.left, depth + 1);
        help(result, root.right, depth + 1);

    }

    public List<List<Integer>> levelOrderByLoop(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int level = 0;
        while (!queue.isEmpty()) {
            //start the current level
            result.add(new ArrayList<>());

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                result.get(level).add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            level++;
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
