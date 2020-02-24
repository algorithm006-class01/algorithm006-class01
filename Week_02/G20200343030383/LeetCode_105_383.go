// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	inorderMap := make(map[int]int)
	for i, v := range inorder {
		inorderMap[v] = i
	}
	_, root := walk(preorder, 0, inorderMap, 0, len(inorder)-1)
	return root
}

func walk(preorder []int, pId int, inorderMap map[int]int, istart, iend int) (int, *TreeNode) {
	if istart > iend {
		return pId, nil
	}

	/* make root node */
	root := &TreeNode{Val: preorder[pId]}
	splitID := inorderMap[preorder[pId]]

	/* build left */
	pId, root.Left = walk(preorder, pId+1, inorderMap, istart, splitID-1)

	/* build right */
	pId, root.Right = walk(preorder, pId, inorderMap, splitID+1, iend)

	return pId, root
}
