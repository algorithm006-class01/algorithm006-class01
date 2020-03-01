/*
 * @lc app=leetcode.cn id=144 lang=swift
 *
 * [144] 二叉树的前序遍历
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
    func preorderTraversal(_ root: TreeNode?) -> [Int] {
        guard let root = root else{
            return [Int]();
        }
        var stack = Array<TreeNode>()
        
        var result = [Int]()
        stack.append(root)
        while(stack.count > 0){
            let node = stack.removeLast()
            result.append(node.val)
            
            if let right = node.right{
                stack.append(right)
            }
            
            if let left = node.left{
                stack.append(left)
            }
            
            
        }
        
        return result
    }
}
// @lc code=end

