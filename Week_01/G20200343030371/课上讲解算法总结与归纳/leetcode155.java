package com;

import java.util.Stack;
//最小栈
public class leetcode155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            //入栈
            stack.push(x);
            //判断是否入最小栈
            if (minStack.isEmpty() || minStack.peek() >= x){
                minStack.push(x);
            }
        }

        public void pop() {
            if (!stack.empty()){
                int top = stack.pop();
                if (!minStack.isEmpty() && top == minStack.peek()){
                    minStack.pop();
                }
            }
        }

        public int top() {
            if (!stack.empty())
                return stack.peek();
            return 0;
        }

        public int getMin() {
            if (!minStack.empty()){
                return minStack.peek();
            }
            return 0;
        }
    }
}
