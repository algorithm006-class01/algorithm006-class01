//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
package lowest_common_ancestor_BT_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLowestAncestorBT(t *testing.T) {
	node1 := TreeNode{
		Val:   7,
		Left:  nil,
		Right: nil,
	}

	node2 := TreeNode{
		Val:   4,
		Left:  nil,
		Right: nil,
	}

	node3 := TreeNode{
		Val:   6,
		Left:  nil,
		Right: nil,
	}

	node4 := TreeNode{
		Val:   2,
		Left:  &node1,
		Right: &node2,
	}

	node5 := TreeNode{
		Val:   0,
		Left:  nil,
		Right: nil,
	}

	node6 := TreeNode{
		Val:   8,
		Left:  nil,
		Right: nil,
	}

	node7 := TreeNode{
		Val:   5,
		Left:  &node3,
		Right: &node4,
	}

	node8 := TreeNode{
		Val:   1,
		Left:  &node5,
		Right: &node6,
	}

	root := TreeNode{
		Val:   3,
		Left:  &node7,
		Right: &node8,
	}

	assert.Equal(t, 3, lowestCommonAncestor(&root, &node7, &node8).Val)
	assert.Equal(t, 5, lowestCommonAncestor(&root, &node7, &node2).Val)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	//如果当前节点为空，返回空
	if root == nil {
		return root
	}

	//如果当前节点就是目标节点p或q,则返回当前节点
	if root == p || root == q {
		return root
	}

	//递归到左右子树上处理
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	//如果左右子树上各找到一个节点，则当前根节点root就是最小公共祖先
	//如果只有一个非空，则返回那个非空的节点
	//如果都为空，则返回空指针
	if left != nil && right != nil {
		return root
	} else if left != nil {
		return left
	} else if right != nil {
		return right
	} else {
		return nil
	}
}
