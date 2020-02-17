"""
    反转一个单链表。

    示例:
        输入: 1->2->3->4->5->NULL
        输出: 5->4->3->2->1->NULL
"""


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseList(self, head):
        pass

    @classmethod
    def recursive(cls, head):
        """
            递归的方法：
                找到最后一个节点，然后依此往回归纳更新。
            时间复杂度:O(n)，空间复杂度O(n)
        """
        if head is None or head.next is None:
            return head

        new_head = cls.recursive(head.next)
        head.next.next = head
        head.next = None
        return new_head

    @classmethod
    def loop(cls, head):
        """
            循环判断：
            5->4->3-2-1

            loop1: 5->4->3->2->1   4->3->2->1  5
            loop2: 4->3->2->1  3->2->1   4->5
            loop3: 3->2->1  2->1  3->4->5
            loop4: 2->1 1  2->3->4->5
            loop5: 1    None 1->2->3->4->5

            时间复杂度O(n)，空间复杂度O(1)

        """
        if not head or head.next is None:
            return head

        prev = None
        while head:
            tmp_node = head.next

            head.next = prev

            prev, head = head, tmp_node
        return prev
