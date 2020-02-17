package cn.geet.week1;

/**
 * leetcode 641 循环双端队列
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月15日 13:23:00
 */
public class LeetCode_641_363 {

    /**
     * 双端队列 是栈和队列的组合模式, 可以两边同时操作
     */
    private int capacity;
    private int[] arr;
    private int head = 0;
    private int tail = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_363(int k) {
        capacity = k + 1;
        arr = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        // 判断队列是否满
        if (isFull()) {
            return false;
        }
        head = (head - 1 + capacity) % capacity;
        arr[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return head == (tail + 1) % capacity;
    }

}
