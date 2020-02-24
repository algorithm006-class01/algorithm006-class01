/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}

	var l3Fast *ListNode = nil  //新的链表第一个节点
	var l3Last *ListNode = nil  //新链表最后节点
	var newNode *ListNode = nil //新创建节点

	for true {
		//对比l1和l2当前值,取较小值,取值链表前进一步
		if l1.Val > l2.Val {
			newNode = l2
			l2 = l2.Next
		} else {
			newNode = l1
			l1 = l1.Next
		}

		//较小值链接到l3
		if l3Last == nil {
			l3Fast = newNode
			l3Last = newNode
		} else {
			l3Last.Next = newNode
			l3Last = newNode
		}

		//如果l1和l2其中一个已经遍历完,另一个剩余部分直接拼接到新链表尾部
		if l1 == nil {
			l3Last.Next = l2
			break
		} else if l2 == nil {
			l3Last.Next = l1
			break
		}
	}

	return l3Fast

}
