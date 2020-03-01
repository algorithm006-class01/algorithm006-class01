/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (64.00%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    69.3K
 * Total Submissions: 108K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

public class TreeNode {
  var val: Int
  var left, right: TreeNode?
  init(_ val: Int) {
    self.val = val
  }
}

class Solution {
  func preorderTraversal(_ root: TreeNode?) -> [Int] {

  }
  
  // 递归
  func preorderTraversal0(_ root: TreeNode?) -> [Int] {
    guard let p = root else {return []}
    var res: [Int] = [p.val]
    res.append(contentsOf: preorderTraversal0(p.left))
    res.append(contentsOf: preorderTraversal0(p.right))
    return res
  }
  
  // 迭代
  func preorderTraversal1(_ root: TreeNode?) -> [Int] {
    if root == nil {return []}
    var res: [Int] = Array(), stack: [TreeNode] = Array()
    var p = root
    stack.append(p!)
    while !stack.isEmpty {
      p = stack.popLast()!
      res.append(p!.val)
      if p!.right != nil {
        stack.append(p!.right!)
      }
      if p!.left != nil {
        stack.append(p!.left!)
      }
    }
    return res
  }
}

// @lc code=end

