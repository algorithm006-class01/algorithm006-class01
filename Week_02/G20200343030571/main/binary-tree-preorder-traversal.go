package main

import (
	"fmt"
	)

/*
	二叉树的前序遍历
	给定一个二叉树，返回它的 前序 遍历。
 	示例:

	输入: [1,null,2,3]
  		 1
		  \
		   2
		  /
   		 3

	输出: [1,2,3]
*/

/*
	递归法
	1.终止条件
	2.处理这一层
	3.进入下一层
	4.回收资源

	自己写了递归的算法，开始时出了一个比较低级的错误，直接传了slice的值
	这是因为自己记错了切片的底层实现，切片中含有指向底层数组的指针，但那个不等于指向切片的指针。
	golang的函数传参只有值传递，所以要传进指向res切片的指针才行。

	！！！ 但是因为我印象中一直是记得golang虽然是值传递，但是会自动对slice做一些处理，导致会造成似乎是传引用的幻觉。
	查了一些博客，自己写了test.go的测试用例，发现更迷糊了。测试用例的结果似乎是与这次代码的结果相冲突？
	求解答
*/

/*type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}*/

func traversal(node *TreeNode, res []int) {
	if node == nil {
		return
	}
	res = append(res, node.Val)
	fmt.Println(res)
	traversal(node.Left, res)
	traversal(node.Right, res)
}

func preorderTraversal1(root *TreeNode) []int {
	if root == nil {return nil}
	res := make([]int, 0, 0)
	traversal(root, res)
	return res
}

/*
	通过看别人的题解，明白了迭代法,但是需要栈，golang没有栈
	我自己试着实现一下
	通过了，感觉通过自己实现了个栈，对golang的空接口又熟练了一点
	说实话，自己用golang写了一年半的业务代码都没怎么接触空接口

	写完去国际站看了下，也有用golang写迭代法的，思路和我基本一致。只不过是没有额外单独将stack这个
	类型实现。
*/

type stack []interface {}

func (s *stack) len() int {
	return len(*s)
}

func (s *stack) pop() interface{} {
	if s.isEmpty() {return nil}
	tempStack := *s
	res := tempStack[len(*s)-1]
	*s = tempStack[:len(*s)-1]
	return res
}

func (s *stack) push(i interface{}) {
	*s = append(*s, i)
}

func (s *stack) isEmpty() bool {
	if len(*s) == 0 {
		return true
	}
	return false
}

func preorderTraversal(root *TreeNode) []int {
	if root == nil {return nil}		//一开始又忘了判空了

	stack := make(stack, 0, 0)
	res := make([]int, 0, 0)
	stack.push(root)
	for !stack.isEmpty() {
		tempNode := stack.pop().(*TreeNode)
		res = append(res, tempNode.Val)
		//一开始这里忘判空了，和递归不一样，因为递归会在每层开头判空
		if tempNode.Right != nil {
			stack.push(tempNode.Right)
		}
		if tempNode.Left != nil {
			stack.push(tempNode.Left)
		}
	}
	return res
}

/*func main() {
	Node3 := TreeNode {
		Val:	int(3),
		Left:	nil,
		Right:	nil,
	}
	Node2 := TreeNode {
		Val: 	int(2),
		Left:	&Node3,
		Right:	nil,
	}
	Node1 := TreeNode {
		Val:   	int(1),
		Left:  	nil,
		Right: 	&Node2,
	}

	res := preorderTraversal(&Node1)
	fmt.Println(res)
	return
}*/