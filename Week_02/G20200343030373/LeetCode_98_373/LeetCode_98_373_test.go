//https://leetcode-cn.com/problems/validate-binary-search-tree/
package validate_BST_test

import (
	"github.com/stretchr/testify/assert"
	"math"
	"sort"
	"testing"
)

func TestValidBST(t *testing.T) {
	t.Log("Validate Binary Search Tree")

	left := TreeNode{
		Val:   1,
		Left:  nil,
		Right: nil,
	}

	right := TreeNode{
		Val:   3,
		Left:  nil,
		Right: nil,
	}

	root := TreeNode{
		Val:   2,
		Left:  &left,
		Right: &right,
	}

	assert.Equal(t, true, isValidBST(&root))
	assert.Equal(t, true, isValidBSTConquerDivider(&root))
	assert.Equal(t, true, isValidBSTInOrderTraversal(&root))
	assert.Equal(t, true, isValidBSTInOrderTraversalPre(&root))

	node1 := TreeNode{
		Val:   3,
		Left:  nil,
		Right: nil,
	}

	node2 := TreeNode{
		Val:   6,
		Left:  nil,
		Right: nil,
	}

	node3 := TreeNode{
		Val:   4,
		Left:  &node1,
		Right: &node2,
	}

	node4 := TreeNode{
		Val:   1,
		Left:  nil,
		Right: nil,
	}

	root1 := TreeNode{
		Val:   5,
		Left:  &node4,
		Right: &node3,
	}

	assert.Equal(t, false, isValidBST(&root1))
	assert.Equal(t, false, isValidBSTConquerDivider(&root1))
	assert.Equal(t, false, isValidBSTInOrderTraversal(&root1))
	assert.Equal(t, false, isValidBSTInOrderTraversalPre(&root1))

	root2 := TreeNode{
		Val:   0,
		Left:  nil,
		Right: nil,
	}
	assert.Equal(t, true, isValidBSTInOrderTraversalPre(&root2))

	root3 := TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val:   1,
			Left:  nil,
			Right: nil,
		},
		Right: nil,
	}
	assert.Equal(t, false, isValidBSTInOrderTraversalPre(&root3))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isValidBST(root *TreeNode) bool {
	return isValidBSTConquerDivider(root)
}

//Method1: Recursively - Conquer and Divider
//T: O(N), S:O(1)
func isValidBSTConquerDivider(root *TreeNode) bool {
	return isBST(root, math.MinInt64, math.MaxInt64)
}

//这个节点root，要比left大，要比right小
func isBST(root *TreeNode, left, right int) bool {
	if root == nil {
		return true
	}

	if left >= root.Val || right <= root.Val {
		return false
	}

	//root的左子节点，要比left大，要比root的值小
	//root的右子节点，要比root的值大，要比right小
	return isBST(root.Left, left, root.Val) && isBST(root.Right, root.Val, right)
}

//Method2: InOrder Traversal to a Sorted List
//T: O(N). S:O(N)
func isValidBSTInOrderTraversal(root *TreeNode) bool {
	nums := InOrderTraversal(root)

	//每个节点不重复
	hash := make(map[int]int)
	for index, value := range nums {
		if _, ok := hash[value]; ok {
			return false
		}

		hash[value] = index
	}

	//判断是否为升序
	return sort.IntsAreSorted(nums)
}

func InOrderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}

	var ret []int

	//...语法，slice被打散进行传递
	ret = append(ret, InOrderTraversal(root.Left)...)
	ret = append(ret, root.Val)
	ret = append(ret, InOrderTraversal(root.Right)...)

	return ret
}

//Method3: InOrder Traversal Upgrade: Current bigger than Previous
//T: O(N), S:O(1)
//这个解法是基于二叉树的中序遍历
//定义一个变量用于存储上一遍历结点的值
//递归遍历二叉树
//如果左子树返回true，对比根节点与缓存变量的值
//如果2.4的对比成立，则将根节点的值赋给缓存变量
//递归遍历右子树

//Method3: 方法1：pre作为全局变量，
//LeetCode，Not AC, Error ! - 上[0]这个测试用例是错误的
//但在单元测试却是AC
/*
var pre int = math.MinInt64

func isValidBSTInOrderTraversalPre(root *TreeNode) bool {
	if root == nil {
		return true
	}

	if isValidBSTInOrderTraversalPre(root.Left) {
		if pre < root.Val {
			pre = root.Val
			return isValidBSTInOrderTraversalPre(root.Right)
		}
	}
	return false
}
*/

//Method3: 方法2：pre作为局部变量，且传递的是地址，则每次遍历对pre做的修改都有效
//LeetCode通过，AC
func isValidBSTInOrderTraversalPre(root *TreeNode) bool {
	pre := math.MinInt64
	return isValidBSTInOrderPre(root, &pre) //注意要传地址，否则[1,1]测试用例不通过
}

func isValidBSTInOrderPre(root *TreeNode, pre *int) bool {
	if root == nil {
		return true
	}

	if isValidBSTInOrderPre(root.Left, pre) {
		if *pre < root.Val {
			*pre = root.Val
			return isValidBSTInOrderPre(root.Right, pre)
		}
	}
	return false
}
