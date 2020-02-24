package G20200343030391;

import java.util.Stack;

public class LeetCode_155_391 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // 返回 -3.
        minStack.pop();
        minStack.top();      // 返回 0.
        minStack.getMin();   // 返回 -2.

    }

    public static class MinStack {
        Stack<Integer> dataStack;
        Stack<Integer> minStack;


        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }

        }

        public void pop() {
            if (!dataStack.isEmpty()) {
                dataStack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (!dataStack.isEmpty()) {
                return dataStack.peek();
            } else {
                throw new RuntimeException("stack is empty");
            }
        }

        public int getMin() {
            if (!dataStack.isEmpty()) {
                return minStack.peek();
            } else {
                throw new RuntimeException("stack is empty");
            }
        }
    }

}
