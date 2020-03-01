package G20200343030391;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_515_391 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node3;
        node1.right = node2;
        node3.left = node5;
        node3.right = node4;
        node2.right = node7;
        List<Integer> list = new LeetCode_515_391().largestValues(node1);
        System.out.println(list);
    }

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        currentLevelMax(root, 0, list);
        return list;
    }

    private void currentLevelMax(TreeNode root, int level, ArrayList<Integer> list) {
        //terminator
        if (root == null) {
            return;
        }
        //process logic
        if (list.size() == level) {
            list.add(root.val);
        } else {
            Integer current = list.get(level);
            if (current == null) {
                list.add(root.val);
            } else {
                list.set(level, Math.max(current, root.val));
            }
        }
        //drill down
        if (root.left != null) {
            currentLevelMax(root.left, level + 1, list);
        }
        if (root.right != null) {
            currentLevelMax(root.right, level + 1, list);
        }
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
