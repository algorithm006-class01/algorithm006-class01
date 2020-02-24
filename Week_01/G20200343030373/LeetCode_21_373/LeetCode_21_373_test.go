//https://leetcode-cn.com/problems/merge-two-sorted-lists/
package merge_two_sorted_lists

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestMergeList(t *testing.T) {
	l1 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val:  4,
				Next: nil,
			},
		},
	}

	l2 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val:  4,
				Next: nil,
			},
		},
	}

	expect := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 1,
			Next: &ListNode{
				Val: 2,
				Next: &ListNode{
					Val: 3,
					Next: &ListNode{
						Val: 4,
						Next: &ListNode{
							Val:  4,
							Next: nil,
						},
					},
				},
			},
		},
	}

	assert.Equal(t, traversalList(expect), traversalList(mergeTwoLists(l1, l2)))
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

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	pre := &ListNode{}
	hint := pre //哨兵或锚点

	//迭代开始，退出时肯定是l1或l2为空了
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			pre.Next = l1 //将pre指向l1当前节点
			l1 = l1.Next  //l1后移
		} else {
			pre.Next = l2
			l2 = l2.Next
		}
		pre = pre.Next //当前pre已经有了指向，则将pre后移一个元素
	}

	//l1或l2为空之后，跳出上面循环
	//将不为空的那个直接合并
	if l1 != nil {
		pre.Next = l1
	} else {
		pre.Next = l2
	}

	return hint.Next
}
