/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 *
 * https://leetcode-cn.com/problems/design-circular-deque/description/
 *
 * algorithms
 * Medium (48.50%)
 * Likes:    23
 * Dislikes: 0
 * Total Accepted:    4.5K
 * Total Submissions: 9.2K
 * Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * 
 * 
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 
 * 
 * 示例：
 * 
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);                    // 返回 true
 * circularDeque.insertLast(2);                    // 返回 true
 * circularDeque.insertFront(3);                    // 返回 true
 * circularDeque.insertFront(4);                    // 已经满了，返回 false
 * circularDeque.getRear();                  // 返回 2
 * circularDeque.isFull();                        // 返回 true
 * circularDeque.deleteLast();                    // 返回 true
 * circularDeque.insertFront(4);                    // 返回 true
 * circularDeque.getFront();                // 返回 4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * 
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
