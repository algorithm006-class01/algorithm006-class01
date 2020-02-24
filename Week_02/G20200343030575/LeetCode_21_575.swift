/*
 * @lc app=leetcode.cn id=21 lang=swift
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */

 //算法上看似简单，写代码时在细节上会出错，代码熟练度不够
 // 1. while 循环的条件是 ||, 写成了 && 
 // 2. left 和 right 的初始值没有先赋值
class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        if l1 == nil {
            return l2
        }
        
        if l2 == nil {
            return l1
        }
        
        
        let result: ListNode?
        var current : ListNode?
        
        var left = l1, right = l2
        if l1!.val <= l2!.val {
            result = l1
            current = l1
            left = l1?.next
        }else{
            result = l2
            current = l2
            right = l2?.next
        }
        
        while left != nil || right != nil {
            
            if left == nil {
                current!.next = right
                break
            }else if right == nil {
                current!.next = left
                break
            }else{
                if left!.val < right!.val {
                    current!.next = left
                    left = left?.next
                }else{
                    current!.next = right
                    right = right?.next
                }
                current = current!.next
            }
        }
        
        
        return result
        
    }
}
// @lc code=end

