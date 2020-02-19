//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
package max_depth_binary_tree_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMaxDepth(t *testing.T) {
	t.Log("Max Depth of Binary Tree: BFS, DFS")

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
	assert.Equal(t, 3, maxDepth(&root))
	assert.Equal(t, 3, dfsMaxDepth(&root))
	assert.Equal(t, 3, bfsMaxDepth(&root))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	return dfsMaxDepth(root)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func dfsMaxDepth(root *TreeNode) int {
	//递归终止条件，当前节点为空
	if root == nil {
		return 0
	}
	return 1 + max(dfsMaxDepth(root.Left), dfsMaxDepth(root.Right))
}

func bfsMaxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	var queue []*TreeNode       //BFS使用队列
	queue = append(queue, root) //根节点入队
	depth := 0                  //初始化深度为0，MinDepth初始化为1

	for len(queue) > 0 {
		n := len(queue)          //怎样确定本层结束？Batch Process，获得长度后再遍历
		for i := 0; i < n; i++ { //遍历当前层的各个节点
			root = queue[0] //以当前节点作为根节点，将其左右子节点入队
			queue = queue[1:]
			if root.Left != nil {
				queue = append(queue, root.Left)
			}
			if root.Right != nil {
				queue = append(queue, root.Right)
			}
		}
		depth++ //本层结束后，深度累加；什么时候是最大深度？BFS遍历结束后即是最大深度
	}
	return depth
}
