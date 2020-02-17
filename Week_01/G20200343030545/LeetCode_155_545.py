"""
    设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) -- 将元素 x 推入栈中。
    pop() -- 删除栈顶的元素。
    top() -- 获取栈顶元素。
    getMin() -- 检索栈中的最小元素。

    示例:
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   --> 返回 -3.
        minStack.pop();
        minStack.top();      --> 返回 0.
        minStack.getMin();   --> 返回 -2.
"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.__ori_stack = []
        self.__min_stack = []

    def empty(self) -> bool:
        return not bool(self.__ori_stack)

    def push(self, x: int) -> None:
        self.__ori_stack.append(x)
        if self.__min_stack:

            # 这个if else是重点。
            if self.__min_stack[-1] > x:
                # 如果最小栈的站定元素比新值大， 压栈
                self.__min_stack.append(x)
            else:
                # 反之 将最小栈的栈顶元素再压到最小栈，这样做的好吃时，出栈时不用考虑那么多，直接出就行
                self.__min_stack.append(self.__min_stack[-1])
        else:
            self.__min_stack.append(x)

    def pop(self) -> None:
        if not self.empty():
            self.__ori_stack.pop()
            self.__min_stack.pop()

    def top(self) -> int:
        if not self.empty():
            return self.__ori_stack[-1]
        raise

    def getMin(self) -> int:
        if not self.empty():
            return self.__min_stack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
