/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (54.38%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    32.4K
 * Total Submissions: 56.9K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 
 * 
 * 进阶：
 * 
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Stack;
class Solution {
    /*
     * 解决方案：先将链表分别入栈，然后同时出栈，做加法
     * (自己最初写法)
     * 时间复杂度：O(max(N1, N2))
     * 空间复杂度：O(N1 + N2)
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null;
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0; // 进位
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int temp = carry;
            if (!stack1.isEmpty()) temp += stack1.pop();
            if (!stack2.isEmpty()) temp += stack2.pop();
            
            if (temp > 9){
                temp -= 10; 
                carry = 1;
            }
            else
                carry = 0;

            ListNode newHead = new ListNode(temp);
            newHead.next = head;
            head = newHead;
        }
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    
    /*
     * 解决方案：先将链表分别入栈，然后同时出栈，做加法
     * （自己优化后写法）
     * 时间复杂度：O(max(N1, N2))
     * 空间复杂度：O(N1 + N2)
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {    
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0; // 进位
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

    /*
     * 解决方案：先将链表分别入栈，然后同时出栈，做加法
     * (国际站、高票漂亮代码) 
     * 
     * 时间复杂度：O(max(N1, N2))
     * 空间复杂度：O(N1 + N2)
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0); // 处理最后进位有些技巧，否则容易失败
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }

    /*
     * 解决方案：递归解决
     * (国际站、高票漂亮代码) 
     * 
     * 时间复杂度：O(max(N1, N2))
     * 空间复杂度：O(N1 + N2)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);
        if(len2 > len1){
            return addTwoNumbers(l2,l1);
        }
        int diff = len1 - len2;
        ListNode new2 = l2;
        
        
        for(int i = 0 ; i < diff ;i++){
            ListNode temp = new ListNode(0);
            temp.next = new2;
            new2 = temp;
        }
        ListNode dummy = new ListNode(0);
        
        int check = add(dummy,l1,new2);
        if(check == 1){
            ListNode next = dummy.next;
            dummy.next = new ListNode(1);
            dummy.next.next = next;
        }
        return dummy.next;
        
    }
    
    private int add(ListNode dummy,ListNode l1,ListNode new2){
        if(l1 == null){
            return 0;
        }
        int prev = add(dummy,l1.next,new2.next);
        int val = prev + l1.val + new2.val;
        if(val >= 10){
            val -= 10;
            ListNode next = dummy.next;
            dummy.next = new ListNode(val);
            dummy.next.next = next;
            return 1;
        }else{
            ListNode next = dummy.next;
            dummy.next = new ListNode(val);
            dummy.next.next = next;
            return 0;
        }
        
    }
    
    private int len(ListNode l){
        int len = 0;
        while(l != null){
            len++;
            l = l.next;
        }
        return len;
    }
}
// @lc code=end

