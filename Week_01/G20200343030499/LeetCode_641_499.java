/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */
// @lc code=start
/**
 * 用数组实现
 * 循环使用下标避免不必要的数据移动
 * head, tail分别表示头和尾下标
 * head == tail时表示满
 * tail + 1 == head时表示空
 */
class MyCircularDeque {
    private int[] data;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        // Can't support k < 1. Assume k >= 1
        data = new int[k + 1];
        head = 1;
        tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        data[head] = value;
        head = (head + 1) % data.length;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (data.length + tail - 1) % data.length;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (data.length + head - 1) % data.length;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail + 1) % data.length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[(data.length + head - 1) % data.length];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tail + 1) % data.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (tail + 1) % data.length == head;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return head == tail;
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
