//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
package binary_tree_level_order_traversal_test

import (
	"container/list"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestTreeTraversal(t *testing.T) {
	t.Log("Binary Tree Level Order Traversal: BFS, DFS")

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

	expect := [][]int{
		{3},
		{9, 20},
		{15, 7},
	}

	assert.Equal(t, expect, levelOrder(&root))
	assert.Equal(t, expect, bfsSlice(&root))
	assert.Equal(t, expect, bfsList(&root))
	assert.Equal(t, expect, dfsLevelOrder(&root))

	root1 := TreeNode{
		Val: 0,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 1,
				Left: &TreeNode{
					Val:   5,
					Left:  nil,
					Right: nil,
				},
				Right: &TreeNode{
					Val:   1,
					Left:  nil,
					Right: nil,
				},
			},
			Right: nil,
		},
		Right: &TreeNode{
			Val: 4,
			Left: &TreeNode{
				Val:  3,
				Left: nil,
				Right: &TreeNode{
					Val:   6,
					Left:  nil,
					Right: nil,
				},
			},
			Right: &TreeNode{
				Val:  -1,
				Left: nil,
				Right: &TreeNode{
					Val:   8,
					Left:  nil,
					Right: nil,
				},
			},
		},
	}

	expect1 := [][]int{
		{0},
		{2, 4},
		{1, 3, -1},
		{5, 1, 6, 8},
	}

	assert.Equal(t, expect, bfsSliceVisited(&root))
	assert.Equal(t, expect1, bfsSliceVisited(&root1)) //Val=1有重复，但允许
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	//return bfsSlice(root)
	return dfsLevelOrder(root)
}

//method1: dfs
func dfsLevelOrder(root *TreeNode) [][]int {
	var levels [][]int //定义好一个二维数组，在每个level层填充二维数组内部的一维数组
	dfs(root, 0, &levels)
	return levels
}

func dfs(root *TreeNode, level int, levels *[][]int) {
	//终止条件，所以无需额外判断有无子节点
	if root == nil {
		return
	}

	if len(*levels) <= level { //当前层为新层
		*levels = append(*levels, []int{root.Val})
	} else { //之前已经深度遍历过：dfs
		(*levels)[level] = append((*levels)[level], root.Val)
	}

	dfs(root.Left, level+1, levels)
	dfs(root.Right, level+1, levels)
}

//method2.1 bfs
//queue in slice
func bfsSlice(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var levels [][]int
	var queue []*TreeNode       //申请一个队列
	queue = append(queue, root) //根节点插入

	for len(queue) > 0 {
		var level []int
		//完全可以使用range，因为range使用的是range那一刻的拷贝，不会随后面queue的append而延长
		//但为了表示Batch Process，先获得当前长度后遍历，表示当前层结束 - 更清晰表达算法
		//for _, node := range queue {
		n := len(queue)
		for i := 0; i < n; i++ {
			node := queue[0]
			queue = queue[1:] //删除队首元素

			level = append(level, node.Val) //将当前层的所有节点加入结果数组中

			//将当前节点子节点加入队列
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		levels = append(levels, level) //添加当前层次的所有节点
	}
	return levels
}

//method2.2: bfs with visited
//if need visited to adjust repeat
func bfsSliceVisited(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var levels [][]int

	//判重，不应存储.Val值，应存储node的地址 - 允许Val值重复
	//var visited map[*TreeNode]int - 会报错，make不仅生成实例还会初始化初值
	visited := make(map[*TreeNode]int)

	var queue []*TreeNode
	queue = append(queue, root)

	for len(queue) > 0 {
		var level []int
		n := len(queue)
		for i := 0; i < n; i++ {
			node := queue[0]
			queue = queue[1:]

			//判重，如果之前已经处理过了，就跳过；否则就记录下来
			//二叉树中有环的话，即可通过visited判重
			if _, ok := visited[node]; ok {
				continue
			}
			visited[node] = node.Val

			level = append(level, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		levels = append(levels, level)
	}
	return levels
}

//method2.3: bfs
//queue in container.list
func bfsList(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var levels [][]int

	queue := list.New()
	queue.PushBack(root)

	for queue.Len() > 0 {
		var level []int
		n := queue.Len()
		for i := 0; i < n; i++ {
			node := queue.Remove(queue.Front()).(*TreeNode) //取队首元素并删除队首元素

			level = append(level, node.Val)

			if node.Left != nil {
				queue.PushBack(node.Left)
			}
			if node.Right != nil {
				queue.PushBack(node.Right)
			}
		}
		levels = append(levels, level)
	}
	return levels
}
