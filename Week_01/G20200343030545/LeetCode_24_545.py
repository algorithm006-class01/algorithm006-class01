"""
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    示例:
        给定 1->2->3->4, 你应该返回 2->1->4->3.
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        return self.loop(head)

    @classmethod
    def recursive(cls, head: ListNode) -> ListNode:
        """
            递归更新每两个点的链表形态。
            时间复杂度：O(N)，N 指的是链表的节点数量。
            空间复杂度：O(N)，递归过程使用的堆栈空间。
        """
        if not (head and head.next):
            return head

        next_node = head.next
        head.next = cls.recursive(head.next.next)
        next_node.next = head
        return next_node

    @classmethod
    def loop(cls, head: ListNode) -> ListNode:
        """
            循环遍历
            单独设置一个前驱节点，方便
            时间复杂度是O(n)，空间复杂度是O(1)
        """
        root = ListNode(-1)
        root.next = head

        prev = root

        while head and head.next:
            first_node = head
            second_node = head.next

            prev.next = second_node
            first_node.next = second_node.next
            second_node.next = first_node

            head = first_node.next
            prev = first_node

        return root.next
