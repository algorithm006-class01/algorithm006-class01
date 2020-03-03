import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    // 自己写的迭代法
    // public List<List<Integer>> levelOrder(TreeNode root) {

    //     Queue<TreeNode> queue1 = new LinkedList<>();
    //     Queue<TreeNode> queue2 = new LinkedList<>();

    //     List<List<Integer>> results = new ArrayList<>();

    //     if (root != null){
    //         queue1.offer(root);
    //     }else {
    //         return results;
    //     }

    //     List<Integer> level_list = new ArrayList<>();

    //     while (!queue1.isEmpty()){
    //         TreeNode current_node = queue1.poll();

    //         level_list.add(current_node.val);

    //         if (current_node.left != null) queue2.offer(current_node.left);
    //         if (current_node.right != null) queue2.offer(current_node.right);

    //         if (queue1.isEmpty()){
    //             while (!queue2.isEmpty()){
    //                 queue1.offer(queue2.poll());
    //             }
    //             results.add(level_list);
    //             level_list = new ArrayList<>();
    //         }
            
    //     }
    //     return results;
    // }

    // 官方题解的迭代法 bfs
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> levels = new ArrayList<List<Integer>>();
    //     if (root == null) return levels;
    
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     queue.add(root);
    //     int level = 0;
    //     while ( !queue.isEmpty() ) {
    //       // start the current level
    //       levels.add(new ArrayList<Integer>());
    
    //       // number of elements in the current level
    //       int level_length = queue.size();
    //       for(int i = 0; i < level_length; ++i) {
    //         TreeNode node = queue.remove();
    
    //         // fulfill the current level
    //         levels.get(level).add(node.val);
    
    //         // add child nodes of the current level
    //         // in the queue for the next level
    //         if (node.left != null) queue.add(node.left);
    //         if (node.right != null) queue.add(node.right);
    //       }
    //       // go to next level
    //       level++;
    //     }
    //     return levels;
    //   }

    // 递归 dfs
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (root != null) helper(results, root, 0);

        return results;
    }

    private void helper(List<List<Integer>> results, TreeNode current_node, int level){
        
        if (current_node == null){
            return;
        }
        if (results.size() > level){
            results.get(level).add(current_node.val);
        }else {
            results.add(new ArrayList<Integer>());
            results.get(level).add(current_node.val);
        }

        helper(results, current_node.left, level + 1);
        helper(results, current_node.right, level + 1);

    }
}
// @lc code=end

