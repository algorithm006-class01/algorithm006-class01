#
# @lc app=leetcode id=641 lang=python
#
# [641] Design Circular Deque
# 1. use list
# 2. use collection.deque,use appendleft() for insertFront() and popleft() for deleteFront()

# @lc code=start
class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.size = k
        self.Deque = []
        # self.Deque = collection.deque([])

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if len(self.Deque) < self.size:
            self.Deque = [value] + self.Deque
            # self.Deque.appendleft(value)
            return True
        else:
            return False

        

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if len(self.Deque) < self.size:
            self.Deque.append(value)
            return True
        else:
            return False
        

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if len(self.Deque) == 0:
            return False
        else:
            self.Deque = self.Deque[1:]
            # self.Deque.popleft()
            return True

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if len(self.Deque) == 0:
            return False
        else:
            self.Deque.pop()
            return True

        

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if len(self.Deque) == 0:
            return -1
        else:
            return self.Deque[0]
        

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if len(self.Deque) == 0:
            return -1
        else:
            return self.Deque[-1]
        

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        if len(self.Deque) == 0:
            return True
        else:
            return False

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        if len(self.Deque) < self.size:
            return False
        else:
            return True


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

