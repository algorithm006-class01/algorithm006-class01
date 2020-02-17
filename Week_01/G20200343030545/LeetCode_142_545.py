"""
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。
    说明：不允许修改给定的链表。

    示例 1：
        输入：head = [3,2,0,-4], pos = 1
        输出：tail connects to node index 1
        解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
        输入：head = [1,2], pos = 0
        输出：tail connects to node index 0
        解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
        输入：head = [1], pos = -1
        输出：no cycle
        解释：链表中没有环。
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        return self.use_hash(head)

    @classmethod
    def use_hash(cls, head: ListNode) -> ListNode:
        """
            使用hash表保存每个节点的值，在保存之前判断一下如果该节点已经存在则说明已经有环，返回该节点即可。
            时间复杂度O(n)，空间复杂度O(n)
        """
        if not (head and head.next):
            return head

        res = None
        hash_map = {}
        while head and head.next:
            if head in hash_map:
                return head
            hash_map[head] = 0
            head = head.next

        return res

    @classmethod
    def floyd(cls, head: ListNode) -> ListNode:
        res = None

        if not (head and head.next):
            return res

        fast_node = head.next.next
        slow_node = head.next
        check_node = None

        # 找出快慢节点交汇的节点
        while fast_node and fast_node.next:
            if slow_node == fast_node:
                check_node = fast_node
                break
            fast_node = fast_node.next.next
            slow_node = slow_node.next

        # 如果check_code，则说明链表有环。
        if check_node:
            root_node = head
            while check_node != root_node:
                check_node = check_node.next
                root_node = root_node.next
            res = check_node
        return res
