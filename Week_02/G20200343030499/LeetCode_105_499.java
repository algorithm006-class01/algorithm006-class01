/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution_1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // assume preorder and inorder won't be null
        if (preorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode rootNode = new TreeNode(rootVal);
        if (preorder.length == 1) {
            return rootNode;
        }

        int rootIndexInInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndexInInorder = i;
                break;
            }
        }
        int leftSize = rootIndexInInorder;
        int rightSize = inorder.length - leftSize - 1;

        int[][] preorderPartitions = getPreorderPartitions(preorder, leftSize, rightSize);
        int[][] inorderPartitions = getInorderPartitions(inorder, leftSize, rightSize);
        rootNode.left = buildTree(preorderPartitions[0], inorderPartitions[0]);
        rootNode.right = buildTree(preorderPartitions[1], inorderPartitions[1]);

        return rootNode;

    }

    private int[][] getPreorderPartitions(int[] array, int leftSize, int rightSize) {
        // int[] root = new int[] { array[0] };
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            left[i] = array[i + 1];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = array[i + leftSize + 1];
        }
        return new int[][] { left, right };
    }

    private int[][] getInorderPartitions(int[] array, int leftSize, int rightSize) {
        // int[] root = new int[1];
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = array[i + leftSize + 1];
        }
        return new int[][] { left, right };
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeftEnd, int preorderRightEnd,
            int inorderLeftEnd, int inorderRightEnd) {
        if (preorderRightEnd - preorderLeftEnd == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[preorderLeftEnd]);
        if (preorderRightEnd - preorderLeftEnd == 1) {
            return rootNode;
        }

        // find index of the root in inorder
        int rootInInorder = -1;
        for (int i = inorderLeftEnd; i < inorderRightEnd; i++) {
            if (preorder[preorderLeftEnd] == inorder[i]) {
                rootInInorder = i;
                break;
            }
        }
        int leftNodeSize = rootInInorder - inorderLeftEnd;

        rootNode.left = buildTree(preorder, inorder, preorderLeftEnd + 1, preorderLeftEnd + leftNodeSize + 1,
                inorderLeftEnd, rootInInorder);
        rootNode.right = buildTree(preorder, inorder, preorderLeftEnd + leftNodeSize + 1, preorderRightEnd,
                rootInInorder + 1, inorderRightEnd);
        return rootNode;
    }
}
// @lc code=end
