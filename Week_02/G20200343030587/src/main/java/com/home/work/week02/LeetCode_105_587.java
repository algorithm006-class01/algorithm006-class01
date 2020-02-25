package com.home.work.week02;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_105_587 {
    Map<Integer,Integer> map = new HashMap<>();
    private int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i = 0;
        for (int key : inorder) map.put(key, i++);
        return buildTreeHelp(preorder, 0, inorder.length -1);
    }
    TreeNode buildTreeHelp(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIdx++];
        TreeNode node = new TreeNode(rootVal);
        int idx = map.get(rootVal);
        node.left = buildTreeHelp(preorder, left, idx - 1);
        node.right = buildTreeHelp(preorder, idx + 1, right);
        return node;

    }
}
