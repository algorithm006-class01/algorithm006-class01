//https://leetcode-cn.com/problems/swap-nodes-in-pairs/
package swap_nodes_in_pairs_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestSwapNodesInPairs(t *testing.T) {
	t.Log("Swap Nodes in Pairs")

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

	res1 := swapPairs(head)
	assert.Equal(t, []int{2, 1, 4, 3, 5}, traversalList(res1))

	res2 := swapPairsRecursively(res1)
	assert.Equal(t, []int{1, 2, 3, 4, 5}, traversalList(res2))
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

func swapPairs(head *ListNode) *ListNode {
	prev := &ListNode{0, head} //构造指向head的前置指针
	hint := prev               //因为prev指针需要移动，留存一个备份
	for prev.Next != nil && prev.Next.Next != nil {
		//前三个都是调换的步骤，第四个是移动pre进行一下调换
		prev.Next.Next.Next, prev.Next.Next, prev.Next, prev = prev.Next, prev.Next.Next.Next, prev.Next.Next, prev.Next
	}
	return hint.Next //注意不是返回hint
}

func swapPairsRecursively(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	hint := head.Next
	head.Next.Next, head.Next = head, swapPairsRecursively(head.Next.Next)
	return hint
}
