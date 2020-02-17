"""
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

    示例：
        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
"""


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        return self.loop(l1, l2)

    @classmethod
    def recursive(cls, l1: ListNode, l2: ListNode) -> ListNode:
        """
            递归处理
                l1.val > l2.val merge(l2.next, l1)
                l1.val < l2.val merge(l1.next, l2)

            引用网友R.D的一段话：
                "每次都把最小值压入栈，最后出栈的时候，将所有数连在一起就可以了。
                说白了，就是用一个栈维护了顺序。最后的连接，当然是小的连小的，所以l1 小，
                就连到 l1,l2 小就连到 l2，最后先返回的，就是最小的头结点。

            时间复杂度O(m+n)，空间复杂度O(m+n)
        """

        if not (l1 and l2):
            return l1 or l2
        elif l1.val < l2.val:
            l1.next = cls.recursive(l1.next, l2)
            return l1
        else:
            l2.next = cls.recursive(l1, l2.next)
            return l2

    @classmethod
    def loop(cls, l1: ListNode, l2: ListNode) -> ListNode:
        """
            迭代遍历：当两个链表都有值的时候，比较对应的val,更新节点信息。
            迭代结束后，判断两个链表是否有剩余的节点，然后添加进去
            时间复杂度是O(n+m)，空间复杂度是O(1)
        """
        root = ListNode(-1)

        prev = root

        while l1 and l2:
            if l1.val > l2.val:
                prev.next = l2
                l2 = l2.next
            else:
                prev.next = l1
                l1 = l1.next

            prev = prev.next

        prev.next = l1 or l2

        return root.next


if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = None
    Solution.loop(node1, node2)
