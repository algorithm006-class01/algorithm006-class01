import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return makeTreeNode(preorder, 0, preorder.length -1 , inorder, 0, inorder.length -1, inMap);
    }

    public TreeNode makeTreeNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // terminator
        if (preStart > preEnd || inStart > inEnd) return null;

        // process current process
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int moveLeft = inRoot - inStart;

        // drill down
        root.left = makeTreeNode( preorder, preStart + 1, preStart + moveLeft, inorder, inStart, inRoot -1, inMap);
        root.right = makeTreeNode( preorder, preStart + moveLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}

