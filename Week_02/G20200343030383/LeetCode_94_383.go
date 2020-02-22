// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
package leetcode

/* pretty cool code, so I repeat it here */

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) (ret []int) {
	st := &Stack{}
	st.Push(root, White)
	for !st.IsEmpty() {
		if n, color := st.Pop(); color == White {
			st.Push(n.Right, White)
			st.Push(n, Gray)
			st.Push(n.Left, White)
		} else {
			ret = append(ret, n.Val)
		}

	}
	return
}

const (
	White = 1
	Gray  = 2
)

type Stack struct {
	nodes []*TreeNode
	color []int
}

func (st *Stack) Push(n *TreeNode, color int) {
	if n != nil {
		st.nodes = append(st.nodes, n)
		st.color = append(st.color, color)
	}
}

func (st *Stack) IsEmpty() bool {
	return len(st.nodes) == 0
}
func (st *Stack) Pop() (n *TreeNode, c int) {
	if len(st.nodes) > 0 {
		size := len(st.nodes)
		n, c = st.nodes[size-1], st.color[size-1]

		st.nodes = st.nodes[:size-1]
		st.color = st.color[:size-1]
	}
	return
}
