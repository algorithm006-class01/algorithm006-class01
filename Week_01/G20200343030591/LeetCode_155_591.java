class MinStack {


    /**
     * 用两个栈实现，普通栈和只放最小栈的栈 （永远保证栈顶是最小的值可以O（1）的获取）
     * 入栈：只有栈顶元素大于当前要入栈的元素 最小栈才能放值
     * 出栈：只有最小栈与普通栈值一样 才能出栈
     * 获取栈顶元素：用的是普通栈的值
     * 获取最小值：用的是最小栈
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}