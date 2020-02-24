package follow.phenix.ice.algorithm.weektwo;

import java.util.*;

/**
 * @author admin
 */
public class BinaryTreePrevOrder {

    public static void main(String[] args) {

    }

    public List<Integer> prevOrderByStack(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            TreeNode right = pop.right;
            if (right != null) {
                stack.add(right);
            }
            TreeNode left = pop.left;
            if (left != null) {
                stack.add(left);
            }
        }
        return result;
    }

    public List<Integer> prevOrderByRecursion(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        prevOrderRecursion(result, root);
        return result;
    }

    private void prevOrderRecursion(List<Integer> integerList, TreeNode node) {
        integerList.add(node.val);
        TreeNode left = node.left;
        if (left != null) {
            prevOrderRecursion(integerList, left);
        }
        TreeNode right = node.right;
        if (right != null) {
            prevOrderRecursion(integerList, right);
        }
    }
}
