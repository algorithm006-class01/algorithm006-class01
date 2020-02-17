#
# @lc app=leetcode.cn id=641 lang=python3
#
# [641] 设计循环双端队列
#

# @lc code=start
from collections import deque
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.size = k
        self.q = deque()

        

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) >= self.size:
            return False
        self.q.appendleft(value)
        return True
        

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) >= self.size:
            return False
        self.q.append(value)
        return True
        

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) == 0:
            return False
        self.q.popleft()
        return True
        

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) == 0:
            return False
        self.q.pop()
        return True
        

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if len(self.q) == 0:
            return -1
        return self.q[0]
        

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if len(self.q) == 0:
            return -1
        return self.q[-1]
        

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return len(self.q) == 0
        

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.q) == self.size
        


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
# @lc code=end

