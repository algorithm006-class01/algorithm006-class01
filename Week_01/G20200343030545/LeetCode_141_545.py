"""
    给定一个链表，判断链表中是否有环。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。

    示例 1：
        输入：head = [3,2,0,-4], pos = 1
        输出：true
        解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
        输入：head = [1,2], pos = 0
        输出：true
        解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3
        输入：head = [1], pos = -1
        输出：false
        解释：链表中没有环。
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        return self.double_pointer(head)

    @classmethod
    def use_hash(cls, head: ListNode) -> bool:
        """
            依次遍历链表，每次遍历的时候判断该节点是否存在于hash表中。
            如果存在则证明链表有环，反之将节点存入到hash表中。
            时间复杂度O(n)，空间复杂度O(n)
        """
        hash_map = {}
        while head and head.next:
            if head in hash_map:
                return True
            hash_map[head] = 0
            head = head.next
        return False

    @classmethod
    def double_pointer(cls, head: ListNode) -> bool:
        """
            快慢指针循环遍历，当快指针等于慢指针的时候，则说明有环。
            时间复杂度O(n)，空间复杂度O(1)
        """
        if not (head and head.next):
            return False

        slow_node = head.next
        fast_node = head.next.next

        while fast_node and fast_node.next:
            if slow_node == fast_node:
                return True

            slow_node = slow_node.next
            fast_node = fast_node.next.next

        return False
