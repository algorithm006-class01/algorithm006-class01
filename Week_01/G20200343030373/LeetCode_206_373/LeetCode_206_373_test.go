//https://leetcode-cn.com/problems/reverse-linked-list/
package reverse_linkedlist_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestReverseList(t *testing.T) {
	t.Log("Reverse Linked List")
	head := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val:  5,
						Next: nil,
					},
				},
			},
		},
	}

	res1 := reverseListInGoGrammar(head)
	assert.Equal(t, []int{5, 4, 3, 2, 1}, traversalList(res1))

	res2 := reverseListInGeneral(res1)
	assert.Equal(t, []int{1, 2, 3, 4, 5}, traversalList(res2))

	res3 := reverseListRecursively1(res2)
	assert.Equal(t, []int{5, 4, 3, 2, 1}, traversalList(res3))

	res4 := reverseListRecursively2(res3)
	assert.Equal(t, []int{1, 2, 3, 4, 5}, traversalList(res4))

	res5 := reverseListRecursively3(res4)
	assert.Equal(t, []int{5, 4, 3, 2, 1}, traversalList(res5))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func traversalList(head *ListNode) []int {
	var res []int
	for head != nil {
		res = append(res, head.Val)
		head = head.Next
	}
	return res
}

func reverseList(head *ListNode) *ListNode {
	//answer1 - best iteration
	return reverseListInGoGrammar(head)

	//answer2 - best recursion
	//return reverseListRecursively2(head)
}

//iteratively reverse linked list (迭代)，循环5次， O(n)
func reverseListInGoGrammar(head *ListNode) *ListNode {
	var pre *ListNode = nil
	for head != nil {
		//将当前节点的next指向上一个节点
		//则上一个节点更新成当前节点
		//再将当前节点更新为下一个节点
		head.Next, pre, head = pre, head, head.Next
	}
	return pre
}

func reverseListInGeneral(head *ListNode) *ListNode {
	var pre *ListNode = nil
	for head != nil {
		tempNext := head.Next //先存储下一个节点，否则会被覆盖
		head.Next = pre       //将当前节点的next指向上一个节点
		pre = head            //则上一个节点更新成当前节点
		head = tempNext       //再将当前节点更新为下一个节点，进行下一次循环
	}
	return pre
}

//Recursively reverse linked list (递归)，递归5次, O(n)
//尾递归？
//在当前层处理反转，然后再下沉 - 其实就是迭代
func reverseListRecursively1(head *ListNode) *ListNode {
	var pre *ListNode = nil
	return reverse1(pre, head)
}

func reverse1(pre, head *ListNode) *ListNode {
	//terminator
	//如果当前节点为空，要么没有元素，要么循环完毕；循环完毕，则返回前驱节点pre作为结果
	if head == nil {
		return pre
	}
	//precess - 在当前level的处理！
	tempNext := head.Next //如果head不是nil，则head.next不为空，暂存
	head.Next = pre       //将当前节点head的Next指向前驱节点pre - 递归的操作
	//drill down
	//clear - no

	//递归终止条件时把pre返回，一层一层的将这个pre返回即可
	return reverse1(head, tempNext) //进入下一次递归、反转
}

//递归-method1: 将当前节点的Next指向前一节点
//当前层什么也不干，就下沉：递；沉到底之后再返回，并反转：归
//递归的理解：后面的都处理完了，就剩本层了
func reverseListRecursively2(head *ListNode) *ListNode {
	return reverse2(nil, head)
}

func reverse2(pre, head *ListNode) *ListNode {
	//terminator
	if head == nil {
		return pre
	}
	//process - no
	//drill down
	cur := reverse2(head, head.Next)
	head.Next = pre
	return cur
}

//递归-method2：将下一节点的Next指向当前节点
//其实method1就挺好，符合思维:每一步只做反转
//本方法需要每次都把当前节点指向nil，多了n次操作，但好在就一个方法
func reverseListRecursively3(head *ListNode) *ListNode {
	//terminator
	if head == nil || head.Next == nil {
		return head
	}
	//递归下去，当到最后一个，他的Next已经是nil，则将最后一个返回
	cur := reverseListRecursively3(head.Next)
	//归来上一层（本层），在本层的操作是：
	//1. 将下一个节点的Next指向当前节点
	//2。为防止循环，将当前节点的Next指向nil
	head.Next.Next, head.Next = head, nil
	//返回递归传递的最后一个节点
	return cur
}
