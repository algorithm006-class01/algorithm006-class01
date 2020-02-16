"""
很好奇，我写的MyCircularDeque_my运行官方最终测试的时候，跟官方给的答案运行的结果完全相同，不知道为啥就是运行不通过
"""
class MyCircularDeque_my:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.front = 0
        self.capacity = k
        self.rear = self.capacity
        self.arr = [0 for _ in range(self.capacity + 1)]

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False

        self.arr[self.front] = value
        self.front += 1
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        self.arr[self.rear] = value
        self.rear -= 1
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        if self.front == 0:
            self.rear += 1
        else:
            self.front -= 1
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        if self.rear == self.capacity:
            self.front -= 1
        else:
            self.rear += 1
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1
        if self.front == 0:
            return self.arr[self.rear + 1]
        else:
            return self.arr[self.front - 1]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1
        if self.rear == self.capacity:
            return self.arr[0]
        else:
            return self.arr[self.rear + 1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.rear == self.capacity and self.front == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.rear == self.front

    def isArr(self) -> list:
        return self.arr

class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.front = 0
        self.rear = 0
        self.capacity = k + 1
        self.arr = [0 for _ in range(self.capacity)]

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        self.front = (self.front - 1 + self.capacity) % self.capacity
        self.arr[self.front] = value
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        self.arr[self.rear] = value
        self.rear = (self.rear + 1) % self.capacity
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        self.front = (self.front + 1) % self.capacity
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        self.rear = (self.rear - 1 + self.capacity) % self.capacity;
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.arr[self.front]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.arr[(self.rear - 1 + self.capacity) % self.capacity]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.front == self.rear

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return (self.rear + 1) % self.capacity == self.front

    def isArr(self) -> list:
        return self.arr

circularDeque = MyCircularDeque(77)
result1 = [circularDeque.insertFront(89), circularDeque.getRear(), circularDeque.deleteLast(), circularDeque.getRear(),
           circularDeque.insertFront(19), circularDeque.insertFront(23), circularDeque.insertFront(23),
           circularDeque.insertFront(82), circularDeque.isFull(), circularDeque.insertFront(45), circularDeque.isFull(),
           circularDeque.getRear(), circularDeque.deleteFront(), circularDeque.getFront(), circularDeque.getFront(),
           circularDeque.insertLast(74), circularDeque.deleteFront(), circularDeque.getFront(), circularDeque.insertLast(98)]

circularDeque_my = MyCircularDeque_my(77)
result2 = [circularDeque_my.insertFront(89), circularDeque_my.getRear(), circularDeque_my.deleteLast(), circularDeque_my.getRear(),
           circularDeque_my.insertFront(19), circularDeque_my.insertFront(23), circularDeque_my.insertFront(23),
           circularDeque_my.insertFront(82), circularDeque_my.isFull(), circularDeque_my.insertFront(45), circularDeque_my.isFull(),
           circularDeque_my.getRear(), circularDeque_my.deleteFront(), circularDeque_my.getFront(), circularDeque_my.getFront(),
           circularDeque_my.insertLast(74), circularDeque_my.deleteFront(), circularDeque_my.getFront(), circularDeque_my.insertLast(98)]

if result1 == result2:
    print(True)
else:
    print(False)