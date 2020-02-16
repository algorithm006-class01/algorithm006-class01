/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 *
 * https://leetcode-cn.com/problems/design-circular-deque/description/
 * 
 */

// @lc code=start
class MyCircularDeque {

    ListNode dequeFirst;
    ListNode dequeLast;
    int maxLength;
    int currentLength;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        currentLength = 0;
        maxLength = k;
        dequeFirst = new ListNode(0);
        dequeLast = new ListNode(0);
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (currentLength == maxLength) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (isEmpty()) {
            dequeFirst.next = node;
            node.previous =dequeFirst;
            node.next = dequeLast;
            dequeLast.previous = node;
        } else {
            node.next = dequeFirst.next;
            node.previous = dequeFirst;
            node.next.previous = node;
            dequeFirst.next=node;
        }
        currentLength++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (currentLength == maxLength) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (isEmpty()) {
            dequeLast.previous = node;
            node.previous =dequeFirst;
            node.next = dequeLast;
            dequeFirst.next = node;
        } else {
            node.previous = dequeLast.previous;
            node.next = dequeLast;
            node.previous.next = node;
            dequeLast.previous = node;
        }
        currentLength++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (currentLength == 0) {
            return false;
        }
        if (!isEmpty()) {
            dequeFirst.next = dequeFirst.next.next;
            dequeFirst.next.previous = null;
            dequeFirst.next.previous = dequeFirst;
            currentLength--;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (currentLength == 0) {
            return false;
        }
        if (!isEmpty()) {
            dequeLast.previous = dequeLast.previous.previous;
            dequeLast.previous.next = null;
            dequeLast.previous.next = dequeLast;
            currentLength--;
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : dequeFirst.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : dequeLast.previous.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return currentLength == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return maxLength == currentLength;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
