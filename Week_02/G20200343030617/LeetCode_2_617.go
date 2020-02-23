// 144.二叉树的前序遍历


package main


type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	var a []int
	return cds(root, &a)
}

func cds(root *TreeNode, res *[]int) []int {
	if root != nil {
		*res = append(*res, root.Val)
		cds(root.Left, res)
		cds(root.Right, res)
		return *res
	} else {
		return nil
	}
}
