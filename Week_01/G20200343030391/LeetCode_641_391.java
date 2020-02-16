package G20200343030391;

public class LeetCode_641_391 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(8);
        boolean b = myCircularDeque.insertFront(5);
        assert b;
        boolean empty22 = myCircularDeque.isEmpty();
        assert !empty22;
        int front = myCircularDeque.getFront();
        assert front == 5;
        boolean empty = myCircularDeque.isEmpty();
        assert !empty;
        boolean b1 = myCircularDeque.deleteFront();
        assert b1;
        boolean b2 = myCircularDeque.insertLast(3);
        assert b2;
        int rear = myCircularDeque.getRear();
        assert rear == 3;
        boolean empty1 = myCircularDeque.isEmpty();
        assert !empty1;
        boolean b3 = myCircularDeque.insertLast(7);
        assert b3;
        boolean b4 = myCircularDeque.insertFront(7);
        assert b4;
        boolean b5 = myCircularDeque.deleteLast();
        assert b5;
        boolean b6 = myCircularDeque.insertLast(4);
        assert b6;
        boolean empty2 = myCircularDeque.isEmpty();
        assert !empty2;
    }

    public static class MyCircularDeque {

        int size;
        int count;
        MyCircularDequeNode first;
        MyCircularDequeNode last;

        public static class MyCircularDequeNode{
            int val;
            MyCircularDequeNode prev;
            MyCircularDequeNode next;
            public MyCircularDequeNode(int val) {
                this.val = val;
            }
        }

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.count = 0;
            this.size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (count < size) {
                MyCircularDequeNode node = new MyCircularDequeNode(value);
                if (count == 0) {
                    this.first = node;
                    this.last = node;
                } else {
                    MyCircularDequeNode currentFirst = this.first;
                    node.next = currentFirst;
                    currentFirst.prev = node;
                    this.first = node;
                }
                count++;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (count < size) {
                MyCircularDequeNode node = new MyCircularDequeNode(value);
                if (count == 0) {
                    this.first = node;
                    this.last = node;
                } else {
                    MyCircularDequeNode currentLast = this.last;
                    currentLast.next = node;
                    node.prev = currentLast;
                    this.last = node;
                }
                count++;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (count > 0) {
                if (count == 1) {
                    this.first = null;
                    this.last = null;
                } else {
                    MyCircularDequeNode first = this.first;
                    MyCircularDequeNode second = first.next;
                    second.prev = null;
                    first = null;
                    this.first = second;
                }
                count--;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (count > 0) {
                if (count == 1) {
                    this.first = null;
                    this.last = null;
                } else {
                    MyCircularDequeNode currentLast = this.last;
                    MyCircularDequeNode second_to_last = currentLast.prev;
                    second_to_last.next = null;
                    this.last = second_to_last;
                    currentLast = null;
                }
                count--;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (count > 0) {
                return this.first.val;
            } else {
                return -1;
            }
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (count > 0) {
                return this.last.val;
            } else {
                return -1;
            }
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return count == size;
        }
    }
}
