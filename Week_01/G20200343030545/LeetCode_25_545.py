"""
    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。
    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

    示例:
        给定这个链表：1->2->3->4->5
        当 k = 2 时，应当返回: 2->1->4->3->5
        当 k = 3 时，应当返回: 3->2->1->4->5
    说明:
        你的算法只能使用常数的额外空间。
        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        return self.loop(head, k)

    @classmethod
    def loop(cls, head: ListNode, k: int) -> ListNode:

        # FIXME 还没做完
        total_count = cls.find_node_count(head)
        stop_times = total_count - (total_count % k)

        prev_node = head
        total_loop_times = 0

        while True:
            tmp_k = k

            next_node = None
            while prev_node:

                prev_node = prev_node.next
                tmp_k -= 1

                if tmp_k == 0:
                    # 说明在这个节点停止
                    prev_node = prev_node.next

            if total_loop_times == stop_times:
                break

    @classmethod
    def find_node_count(cls, head: ListNode) -> int:
        res = 0
        while head:
            head = head.next
            res += 1
        return res

    @classmethod
    def reverse_node(cls, head: ListNode) -> ListNode:
        prev_node = None
        while head:
            next_node = head.next
            head.next = prev_node
            prev_node = head
            head = next_node

        return prev_node
