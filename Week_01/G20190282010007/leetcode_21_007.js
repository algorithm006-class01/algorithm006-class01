// 题目: 合并两个有序链表
/**
 * 题目描述：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */

 // 解题语言: javaScript

 // 解题

 /**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    // 如果链表l1是空的，那么直接返回l2
    if(l1 === null){
        return l2;
    }
    // 如果链表l2是空的，那么直接返回l1
    if(l2 === null){
        return l1;
    }
    // 递归部分,重组有序的链表
    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }else{
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
};