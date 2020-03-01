package main

/*
	102. 二叉树的层次遍历

	给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

	例如:
	给定二叉树: [3,9,20,null,null,15,7],

		3
	   / \
	  9  20
		/  \
	   15   7
	返回其层次遍历结果：

	[
	  [3],
	  [9,20],
	  [15,7]
	]

*/
/*
	BFS
*/

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func levelOrder1(root *TreeNode) [][]int {
	if root == nil {return [][]int{}}
	queue := make([]*TreeNode, 0)
	res := make([][]int, 0)
	curLev := int(0)
	queue = append(queue, root)
	for len(queue) > 0 {
		res = append(res, []int{})
		len := len(queue)
		for i := 0; i < len; i++ {
			node := queue[0]
			queue = queue[1:]
			res[curLev] = append(res[curLev], node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		curLev++
	}

	return res
}


/*
	DFS 递推
*/

func levelOrder2(root *TreeNode) [][]int {
	res := make([][]int, 0)
	help(root, 0, &res)
	return res
}

func help(node *TreeNode, curLev int, res *[][]int) {
	if node == nil 	{ return }

	if curLev >= len(*res) {
		*res = append(*res, []int{})
	}

	(*res)[curLev] = append((*res)[curLev], node.Val)

	help(node.Left, curLev + 1, res)
	help(node.Right, curLev + 1, res)
}










































