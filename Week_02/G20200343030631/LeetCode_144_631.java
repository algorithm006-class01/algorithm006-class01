package com.dsx.hundred.forty.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 典型递归方式
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗: 37.5 MB, 在所有 Java 提交中击败了5.19%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version1 {
    public static void main(String[] args) {

    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (null == root){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        preOrderTraversalInternal(root, result);
        return result;
    }

    private static void preOrderTraversalInternal(TreeNode node, List<Integer> result){
        if (null == node){
            return;
        }
        result.add(node.val);
        preOrderTraversalInternal(node.left, result);
        preOrderTraversalInternal(node.right, result);
    }
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


package com.dsx.hundred.forty.four;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 解题思路: 使用栈遍历
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了60.73%的用户
 * 内存消耗: 37.7 MB, 在所有 Java 提交中击败了5.19%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version2 {
    public static void main(String[] args) {

    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (null == root){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack();
        treeNodeStack.add(root);
        while (!treeNodeStack.isEmpty()){
            TreeNode tmpNode = treeNodeStack.pop();
            result.add(tmpNode.val);
            if (tmpNode.right != null){
                treeNodeStack.add(tmpNode.right);
            }
            if (tmpNode.left != null){
                treeNodeStack.add(tmpNode.left);
            }
        }
        return result;
    }

    private static void preOrderTraversalInternal(TreeNode root, List<Integer> result) {

    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
