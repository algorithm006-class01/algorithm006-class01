package com.leetcode.practices;

import java.util.Arrays;

public class Solution {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 例如：前序数组preorder = [3,9,20,15,7], 中序数组inorder = [9,3,15,20,7]
     * 由二叉树定义可知，二叉树由根节点+左子树+右子树组成。通过前序遍历可知preorder[0]为根节点
     * 通过inorder可知inorder[0:1]为左子树，inorder[2:]为右子树。
     * 可通过递归算法求解，
     * 1、先从前序数组中取得子树根节点，然后从中序数组中，确定根节点数组位置
     * 2、递归构建左子树（需要确定左子树的前序数组及其中序数组）
     * 3、递归构建右子树（需要确定右子树的前序数组及其中序数组）
     * @param preorder 前序数组
     * @param inorder 中序数组
     * @return 二叉树根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                mid = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;

    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preorder =  new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        buildTree.buildTree(preorder, inorder);
    }
}
