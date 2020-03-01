/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (63.91%)
 * Likes:    208
 * Dislikes: 0
 * Total Accepted:    69.6K
 * Total Submissions: 108.4K
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
package leetcode

// create time: 2020-02-23 20:01

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	// return preorderTraversalUseRecurse(root)
	return preorderTraversalUseIter(root)
}

func preorderTraversalUseRecurse(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	var res []int
	var traversal func(*TreeNode)
	traversal = func(node *TreeNode) {
		// 递归终止条件
		if node == nil {
			return
		}
		// 处理当前节点
		res = append(res, node.Val)
		// 递归左节点
		traversal(node.Left)
		// 递归右节点
		traversal(node.Right)
	}
	traversal(root)
	return res
}

func preorderTraversalUseIter(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	var res []int
	stack := make([]*TreeNode, 0)
	stack = append(stack, root)
	var node *TreeNode
	// 前序遍历 根左右
	for len(stack) > 0 {
		// 当前节点出栈并处理
		node = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		res = append(res, node.Val)
		// 加入右节点（先加入后处理）
		if node.Right != nil {
			stack = append(stack, node.Right)
		}
		// 加入左节点（后加入先处理）
		if node.Left != nil {
			stack = append(stack, node.Left)
		}
	}
	return res
}

// @lc code=end
