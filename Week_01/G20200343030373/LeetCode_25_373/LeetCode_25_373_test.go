//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
package reverse_nodes_in_k_group_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestReverseNodesInKGroup(t *testing.T) {
	t.Log("Reverse Nodes in K-Group")

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

	assert.Equal(t, []int{2, 1, 4, 3, 5}, traversalList(reverseKGroup(head, 2)))
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

//TC: O(n*k), SC:O(1)
//优化：无需k次循环确定是否结束。可边翻转边判断，如果提前结束，再做一次翻转。只有最后一部分会多做一次翻转，但少nk次循环。
func reverseKGroup(head *ListNode, k int) *ListNode {
	if k <= 1 { //注意不要遗漏边界条件
		return head
	}

	pre := &ListNode{0, head} //因为dummy指向head，head指针不能有变化，所以需要一个pre
	hint := pre
	for pre.Next != nil {
		start, end := pre.Next, pre.Next

		for i := 1; i < k; i++ { //注意end已经有一个了，从1开始，k个，所以要小于k
			end = end.Next
			if end == nil {
				break
			}
		}
		if end == nil { //剩余的不够K个，结束
			break
		}

		next := end.Next

		//翻转 start 与 end 区间，end.Next结束，一个完整链表区间
		end.Next = nil
		pre.Next = reverse(start) //已翻转部分与前驱连接
		start.Next = next         //未翻转部分与后区连接

		//重置变量 - 注意不能是pre.Next = next，会遗漏数据
		pre = start
	}
	return hint.Next
}

func reverse(head *ListNode) *ListNode {
	var pre *ListNode = nil
	for head != nil {
		head.Next, head, pre = pre, head.Next, head
	}
	return pre
}
