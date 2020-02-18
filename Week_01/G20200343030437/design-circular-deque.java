class MyCircularDeque {

        private int count = 0;

        private int sum = 0;

        private Node first;

        private Node last;

        /**
         * 自定义链表
         */
        private static class Node {
            int data;
            Node prev;
            Node next;
            public Node (int data, Node prev, Node next) {
                this.data = data;
                this.prev = prev;
                this.next = next;
            }
        }

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.sum = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (count >= sum) {
                return false;
            }
            Node newNode = new Node(value, null, first);


            if(first == null) last = newNode; //同步尾节点
            else first.prev = newNode;

            first = newNode;
            count++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (count >= sum) return false;

            Node newNode = new Node(value, last, null);
            if(last == null) first = newNode; //同步首节点
            else last.next = newNode;

            last = newNode;
            count++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (first == null) return false;

            if (first.next == null) {
                first = null;
                last = null;
            } else if (count == 2){
                first = first.next;
                first.prev = null;
                last = first;
            } else {
                first = first.next;
                first.prev = null;
            }
            count--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (last == null) return false;

            if(last.prev == null) {
                first = null;
                last = null;
            } else if (count == 2) {
                last = last.prev;
                last.next = null;
                first = last;
            } else {
                last = last.prev;
                last.next = null;
            }
            count--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (first == null) return -1;
            return first.data;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (last == null) return -1;
            return last.data;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return count == sum;
        }
    }
