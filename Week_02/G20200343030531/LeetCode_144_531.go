package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	// 1.将数组二叉树化
	root := &TreeNode{Val: 1, Right: &TreeNode{Val: 2, Left: &TreeNode{Val: 3}}}
	fmt.Println(preorderTraversal(root))
}

// 解法一
/*
func preorderTraversal(root *TreeNode) []int {
	var res []int
	helper(root, &res)
	return res
}

func helper(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	*res = append(*res, root.Val)
	helper(root.Left, res)
	helper(root.Right, res)
}
*/
/*
func preorderTraversal(root *TreeNode) (rst []int) {
	if root == nil {
		return nil
	}
	var stack = list.New()
	stack.PushBack(root.Right)
	stack.PushBack(root.Left)

	rst = append(rst, root.Val)
	for stack.Len() != 0 {
		e := stack.Back()
		stack.Remove(e)
		node := e.Value.(*TreeNode)
		if node == nil {
			continue
		}
		rst = append(rst, node.Val)
		stack.PushBack(node.Right)
		stack.PushBack(node.Left)
	}
	return
}

*/

/*
func preOrder(root *TreeNode)  {
	if root == nil {
		return
	}
	fmt.Println(root.Val) // 伪码：获取节点值
	preOrder(root.Left)
	preOrder(root.Right)
}

func inOrder(root *TreeNode)  {
	if root == nil {
		return
	}

	inOrder(root.Left)
	fmt.Println(root.Val) // 伪码：获取节点值
	preOrder(root.Right)
}

func postOrder(root *TreeNode)  {
	if root == nil {
		return
	}
	postOrder(root.Left)
	postOrder(root.Right)
	fmt.Println(root.Val)// 伪码：获取节点值
}
*/

// 尝试模板方法解题
func preorderTraversal(root *TreeNode) (rst []int) {
	res := make([]int, 0)
	preOrder(root, &res)
	return res
}

func preOrder(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	*res = append(*res, root.Val)
	preOrder(root.Left, res)
	preOrder(root.Right, res)
}
