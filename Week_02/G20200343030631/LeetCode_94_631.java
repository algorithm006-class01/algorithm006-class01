package com.dsx.ninety.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 使用递归方式，中序遍历，中止条件为节点为null
 * 时间复杂度: O(n)
 * 空间复杂度: 最坏情况下需要空间O(n)，平均情况为O(logn)
 * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗: 37.8 MB, 在所有 Java 提交中击败了5.10%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/21
 */
public class Version1 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalHelper(root, result);
        return result;
    }

    private void traversalHelper(TreeNode node, List<Integer> result){
        if (null == node){
            return;
        }
        if (null != node.left){
            traversalHelper(node.left, result);
        }
        result.add(node.val);
        if (null != node.right){
            traversalHelper(node.right, result);
        }
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


package com.dsx.ninety.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 解题思路: 使用栈遍历，非最左节点即进栈，找到后出栈，接着出栈父节点，然后遍历父节点的右子节点
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了67.61%的用户
 * 内存消耗: 38.3 MB, 在所有 Java 提交中击败了5.10%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/21
 */
public class Version2 {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> traversalStack = new Stack<>();
        TreeNode current = root;
        while (current != null || !traversalStack.isEmpty()){
            while (current != null){
                traversalStack.push(current);
                current = current.left;
            }
            current = traversalStack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
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
