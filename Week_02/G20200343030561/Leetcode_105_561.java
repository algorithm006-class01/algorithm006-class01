/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
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
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for(int val: inorder) {
            if (val == preorder[0]) break;
            i ++;
        }
        root.left = buildTree(buildArr(preorder, 1, i+1), buildArr(inorder, 0, i));
        root.right = buildTree(buildArr(preorder, i+1, preorder.length), buildArr(inorder, i+1, inorder.length));
        return root;
    }

    public int[] buildArr(int[] arr, int fromIdx, int toIdx){
        if (toIdx - fromIdx <= 0) return new int[0];
        int[] ints = new int[toIdx - fromIdx];
        for (int i = fromIdx; i < toIdx; i++) {
            ints[i - fromIdx] = arr[i];
        }
        return ints;
    }
    
}
// @lc code=end

