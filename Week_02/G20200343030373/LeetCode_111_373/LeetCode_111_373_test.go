//https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
package min_depth_binary_tree_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMinDepth(t *testing.T) {
	t.Log("Min Depth of Binary Tree: BFS, DFS")

	root := TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val:   9,
			Left:  nil,
			Right: nil,
		},
		Right: &TreeNode{
			Val: 20,
			Left: &TreeNode{
				Val:   15,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   7,
				Left:  nil,
				Right: nil,
			},
		},
	}
	assert.Equal(t, 2, minDepth(&root))
	assert.Equal(t, 2, dfsOriginal(&root))
	assert.Equal(t, 2, dfsSimplified(&root))
	assert.Equal(t, 2, bfsMinDepth(&root))

	root1 := TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val:   2,
			Left:  nil,
			Right: nil,
		},
		Right: nil,
	}
	assert.Equal(t, 2, minDepth(&root1))
	assert.Equal(t, 2, dfsOriginal(&root1))
	assert.Equal(t, 2, dfsSimplified(&root1))
	assert.Equal(t, 2, bfsMinDepth(&root1))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func minDepth(root *TreeNode) int {
	return dfsSimplified(root)
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

//dfs original
func dfsOriginal(root *TreeNode) int {
	if root == nil {
		return 0
	}

	//当左右孩子都为空时，返回1
	if root.Left == nil && root.Right == nil {
		return 1
	}

	left := dfsOriginal(root.Left)
	right := dfsOriginal(root.Right)

	//当左右孩子又一个为空时，返回不为空的深度
	if root.Left == nil {
		return 1 + right
	}
	if root.Right == nil {
		return 1 + left
	}

	//最后，当左右孩子都不为空时，返回左右较小的深度
	return 1 + min(left, right)
}

//dfs original -> simplified
func dfsSimplified(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left := dfsOriginal(root.Left)
	right := dfsOriginal(root.Right)

	//简化：左或右为空时，即为0
	if root.Left == nil || root.Right == nil {
		return 1 + left + right
	}

	return 1 + min(left, right)
}

//bfs
func bfsMinDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	var queue []*TreeNode
	queue = append(queue, root)

	//初始化深度为1, MaxDepth初始化为0 - 容易出错！
	//max是遍历完当前层后再返回，所以从0自加
	//min是在当前层就有可能直接返回，所以先设置为1，否则可能没机会自加
	depth := 1

	for len(queue) > 0 {
		n := len(queue)
		for i := 0; i < n; i++ {
			root := queue[0]
			queue = queue[1:]

			//找到第一个叶子节点后直接返回
			if root.Left == nil && root.Right == nil {
				return depth
			}

			if root.Left != nil {
				queue = append(queue, root.Left)
			}
			if root.Right != nil {
				queue = append(queue, root.Right)
			}
		}
		depth++
	}
	return depth //肯定会在第一个叶子节点出返回，此处不会走到
}
