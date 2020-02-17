class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        第一种解法在交换l1.l2的时候比较费时，执行时间为56ms
        第二种执行时间为44ms
        :param l1:
        :param l2:
        :return:
        """
        # if l1 and l2:
        #     if l1.val > l2.val: l1, l2 = l2, l1
        #     l1.next = self.mergeTwoLists(l1.next, l2)
        # return l1 or l2

        if l1 and l2:
            if l1.val < l2.val:
                l1.next = self.mergeTwoLists(l1.next, l2)
                return l1
            else:
                l2.next = self.mergeTwoLists(l2.next, l1)
                return l2
        return l1 or l2