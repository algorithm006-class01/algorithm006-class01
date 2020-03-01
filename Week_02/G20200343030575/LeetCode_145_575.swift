/*
 * @lc app=leetcode.cn id=145 lang=swift
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
class Solution {
    func postorderTraversal(_ root: TreeNode?) -> [Int] {
        guard let root = root else{
            return [Int]();
        }
        var stack = Array<TreeNode>()
        var visitedSet = Set<TreeNode>()
        
        var result = [Int]()
        stack.append(root)
        while(stack.count > 0){
            let node = stack.last!
            if (node.left == nil && node.right == nil) || visitedSet.contains(node){
                result.append(node.val)
                stack.removeLast()
            }else{
                visitedSet.insert(node)
                if let right = node.right{
                    stack.append(right)
                }
                
                if let left = node.left{
                    stack.append(left)
                }
            }
            
            
        }
        return result
    }
}
// @lc code=end

