class MyCircularDeque:

    def __init__(self, k):
        self._size = 0
        self._front, self._rear = 0, 0
        self._capacity = k
        self._data = [-1] * k

    def getFront(self):
        return self._data[self._front]

    def getRear(self):
        return self._data[self._rear]

    def isEmpty(self):
        return self._size == 0

    def isFull(self):
        return self._size == self._capacity

    def insertFront(self, value):
        if self.isFull():
            return False
        if self.isEmpty():
            self._data[self._front] = value
        else:
            self._front = (self._front - 1) % self._capacity
            self._data[self._front] = value
        self._size += 1
        return True

    def insertLast(self, value):
        if self.isFull():
            return False
        if self.isEmpty():
            self._data[self._rear] = value
        else:
            self._rear = (self._rear + 1) % self._capacity
            self._data[self._rear] = value
        self._size += 1
        return True

    def deleteFront(self):
        if self.isEmpty():
            return False
        self._data[self._front] = -1
        self._front = (self._front + 1) % self._capacity
        self._size -= 1
        if self.isEmpty():
            self._rear = self._front
        return True

    def deleteLast(self):
        if self.isEmpty():
            return False
        self._data[self._rear] = -1
        self._rear = (self._rear - 1) % self._capacity
        self._size -= 1
        if self.isEmpty():
            self._front = self._rear
        return True
