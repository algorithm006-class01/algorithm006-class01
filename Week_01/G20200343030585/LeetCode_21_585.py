# -*- coding:utf-8 -*-

# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        解题思路：
        1.使用一个新list保存合并后的数据
        2. 由于两个链表都有序，一次循环两个链表，使用两个指针分别指向两个链表表头
        3. 依次比较两个链表的元素，元素小的添加到新list，然后将指针后移，再进行比较
        4. 如果指针已经大于当前list，直接添加另一个list的所有值
        """
        
        l3 = ListNode("")
        ret = l3

        while l1 and l2:            
            if l1.val > l2.val:
                l3.next = l2
                l2 = l2.next
            else:
                l3.next = l1
                l1 = l1.next
            l3 = l3.next
            
        l3.next = l1 if l1 is not None else l2
        return ret.next
    