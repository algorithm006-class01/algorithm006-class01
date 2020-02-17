# 数组暴力算法：

# def mergeTwoLists(l1, l2):
#     k = 0
#     for i in range(len(l1)):
#         for j in range(k, len(l2)):
#             if l2[j] > l1[i]:
#                 l2.insert(j, l1[i])
#                 k += 1
#                 break
#             if j == (len(l2) - 1):
#                 l2.append(l1[i])
#     return l2
#
#
# l1 = [1, 2, 3, 4]
# l2 = [1, 3, 4, 5]
#
# l3 = mergeTwoLists(l1, l2)
#
# print('reuslt:', l3)


# 链表暴力：递归
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def deepcopy(self):
        nl = ListNode(self.val)
        nl.next = self.next
        return nl


list1 = ListNode(1)
list1.next = ListNode(2)
list1.next.next = ListNode(4)

list2 = ListNode(1)
list2.next = ListNode(3)
list2.next.next = ListNode(4)


class Solution:
    # 递归
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

    # 迭代
    def mergeTwoLists2(self, l1: ListNode, l2: ListNode) -> ListNode:
        prehead = ListNode(-1)

        prev = prehead
        while l1 and l2:
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next

        # exactly one of l1 and l2 can be non-null at this point, so connect
        # the non-null list to the end of the merged list.
        prev.next = l1 if l1 is not None else l2

        return prehead.next


s = Solution()
l = s.mergeTwoLists2(list1, list2)

while l.next is not None:
    print(l.val)
    l = l.next
print(l.val)
