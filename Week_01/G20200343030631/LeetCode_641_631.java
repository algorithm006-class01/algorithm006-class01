/**
 * 解题思路: 用数组存放实际数据，用headpos指示头部位置，tailPos指示尾部下一个元素要插入的位置，capacity指示数组大小，size指示当前大小，头部插入后挪移数据
 * V2：不再挪移数据，采用解题区推荐思路，使用虚拟环的思路，每次插入不再插入数据头部，而是计算插入位置，判别满或者空使用一个额外空间进行
 * 时间复杂度:
 * 空间复杂度:
 * 执行用时: 9 ms, 在所有 Java 提交中击败了33.90%的用户
 * 内存消耗: 40.8 MB, 在所有 Java 提交中击败了9.12%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/2
 */
public class Solution {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4
    }


    private static class MyCircularDeque {
        private int[] datas;
        private int headPos;
        private int tailPos;
        private int capacity;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            capacity = k + 1;
            datas = new int[capacity];
            headPos = 0;
            tailPos = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()){
                return false;
            }
            headPos = (headPos - 1 + capacity) % capacity;
            datas[headPos] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()){
                return false;
            }
            datas[tailPos] = value;
            tailPos = (tailPos + 1) % capacity;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            headPos = (headPos + 1) % capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tailPos = (tailPos - 1 + capacity) % capacity;
            return true;
        }


        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                // 抛异常无法通过leetcode，改为返回-1
//                throw  new UnsupportedOperationException("Empty Deque");
                return -1;
            }
            return datas[headPos];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()){
                // 抛异常无法通过leetcode，改为返回-1
//              throw new UnsupportedOperationException("Empty Deque");
                return -1;
            }

            return datas[(tailPos - 1 + capacity) % capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return headPos == tailPos;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tailPos + 1) % capacity == headPos;
        }

        @Override
        public String toString() {
            return "MyCircularDeque{}";
        }
    }
}
