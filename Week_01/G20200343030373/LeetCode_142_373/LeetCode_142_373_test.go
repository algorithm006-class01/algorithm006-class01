//https://leetcode-cn.com/problems/linked-list-cycle-ii/
package linkedlist_cycle_detect_test

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLinkedListCycleBegin(t *testing.T) {
	fmt.Println("Linked List Cycle Begin")

	head := new(ListNode)
	head.Val = 1
	ln2 := new(ListNode)
	ln2.Val = 2
	ln3 := new(ListNode)
	ln3.Val = 3
	ln4 := new(ListNode)
	ln4.Val = 4
	head.Next = ln2
	ln2.Next = ln3
	ln3.Next = ln4

	headC := new(ListNode)
	headC.Val = 1
	cln2 := new(ListNode)
	cln2.Val = 2
	cln3 := new(ListNode)
	cln3.Val = 3
	cln4 := new(ListNode)
	cln4.Val = 4
	headC.Next = cln2
	cln2.Next = cln3
	cln3.Next = cln4
	cln4.Next = headC //Cycle

	assert.Equal(t, (*ListNode)(nil), detectCycle(head)) //注意nil的表示
	assert.Equal(t, (*ListNode)(nil), detectCycleHash(head))
	assert.Equal(t, headC, detectCycleHash(headC))
	assert.Equal(t, headC, detectCycleHash(headC))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	fast, slow := head, head

	for fast != nil && slow != nil && fast.Next != nil {
		fast, slow = fast.Next.Next, slow.Next
		//当快指针和慢指针相遇了
		if fast == slow {
			//head节点开始走,fast指针改成每次走一步,相遇的时候 就是环形的起点
			for head != fast {
				fast, head = fast.Next, head.Next
			}
			return head
		}
	}
	return nil
}

//Not Good, Need Extra Space
func detectCycleHash(head *ListNode) *ListNode {
	hash := make(map[*ListNode]int)

	for head != nil {
		//如果遇到同一个地址,就是环入口
		if _, ok := hash[head]; ok {
			return head
		}
		hash[head] = head.Val
		head = head.Next
	}

	return nil
}
