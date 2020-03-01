/*
 * @lc app=leetcode.cn id=105 lang=golang
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (63.98%)
 * Likes:    347
 * Dislikes: 0
 * Total Accepted:    44K
 * Total Submissions: 68.5K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start
public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init(_ val: Int) {
         self.val = val
        self.left = nil
        self.right = nil
     }
}

class Solution {

    var preIndex = 0
    var indexMap: [Int: Int] = Dictionary()
    var inorder, preorder: [Int]

    func buildTree(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {

    }

    func buildTree0(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {
      self.preorder = preorder; self.inorder = inorder
      for (item, index) in inorder.enumerated() {
        indexMap[item] = index
      }
      return _helper(0, preorder.count)
    }

    func _helper(_ inLeft: Int, _ inRight: Int) -> TreeNode? {
      if inLeft == inRight {return nil}
      let rootVal = self.preorder[preIndex]
      let root = TreeNode(rootVal)
      if let index = self.inorder.firstIndex(of: rootVal) {
        preIndex += 1
        root.left = _helper(inLeft, index)
        root.right = _helper(index + 1, inRight)
        return root
      }
      return nil
    }
}
// @lc code=end

