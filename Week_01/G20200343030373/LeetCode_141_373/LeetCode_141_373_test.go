//https://leetcode-cn.com/problems/linked-list-cycle/
package linkedlist_cycle_test

import (
	"github.com/stretchr/testify/assert"
	"testing"
	"time"
)

func TestLinkedListCycle(t *testing.T) {
	t.Log("Linked List Cycle")

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
	cln4.Next = cln2 //Cycle

	assert.Equal(t, false, hasCycle(head))
	assert.Equal(t, false, hasCycleChangeVal(head))
	assert.Equal(t, false, hasCycleFindNil(head))
	assert.Equal(t, false, hasCycleSetUnique(head))
	assert.Equal(t, true, hasCycle(headC))
	assert.Equal(t, true, hasCycleChangeVal(headC))
	assert.Equal(t, true, hasCycleFindNil(headC))
	assert.Equal(t, true, hasCycleSetUnique(headC))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

//TC:O(n), SC:O(1)
func hasCycle(head *ListNode) bool {
	fast, slow := head, head
	for fast != nil && slow != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			return true
		}
	}
	return false
}

//Not Good, 10086! head changed!
func hasCycleChangeVal(head *ListNode) bool {
	for head != nil {
		if head.Val == 10086 {
			return true
		}

		head.Val = 10086
		head = head.Next
	}
	return false
}

//Not Good, infinite! head changed!
func hasCycleFindNil(head *ListNode) bool {
	timeFlag := false
	timer := time.NewTimer(1 * time.Second)
	go func() {
		<-timer.C
		timeFlag = true
	}()

	for head != nil {
		if timeFlag {
			return true
		}

		head = head.Next
	}
	return false
}

//Not Good, Need Set Store, TC:O(n), SC: O(n)
func hasCycleSetUnique(head *ListNode) bool {
	hash := make(map[*ListNode]int)
	for head != nil {
		if _, ok := hash[head]; ok {
			return true
		}

		hash[head] = head.Val
		head = head.Next
	}
	return false
}
