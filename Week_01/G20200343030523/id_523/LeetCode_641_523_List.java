package queue;

/**
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class MyCircularDeque {

    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        Node node = new Node(value);
        Node first = head.next;
        node.next = first;
        first.pre = node;
        head.next = node;
        node.pre = head;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        Node node = new Node(value);
        Node last = tail.pre;
        node.pre = last;
        last.next = node;
        node.next = tail;
        tail.pre = node;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        size--;
        Node first = head.next;
        head.next = first.next;
        first.next.pre = head;
        first = null;
        return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size--;
        Node last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        last = null;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.pre.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    class Node {
        int value;
        Node next;
        Node pre;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.pre = null;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.isFull());                        // 返回 true
        System.out.println(circularDeque.deleteLast());                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 返回 true
        System.out.println(circularDeque.getFront());                // 返回 4
    }

}
