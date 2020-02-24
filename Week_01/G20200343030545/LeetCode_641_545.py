"""
    设计实现双端队列。
    你的实现需要支持以下操作：
        MyCircularDeque(k)：构造函数,双端队列的大小为k。
        insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
        insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
        deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
        deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
        getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
        getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
        isEmpty()：检查双端队列是否为空。
        isFull()：检查双端队列是否满了。

    示例：
        MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        circularDeque.getFront();				// 返回 4
 
    提示：

        所有值的范围为 [1, 1000]
        操作次数的范围为 [1, 1000]
        请不要使用内置的双端队列库。
"""


class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.__k = k
        self.__front = 0  # 指向队列头部第 1 个有效数据的位置。
        self.__rear = 0  # 指向队列尾部的下一个位置，即下一个从队尾入队元素的位置。
        self.__capacity = self.__k + 1
        self.__array = [0] * self.__capacity  # 多存储一个空间用于 区分 队列满还是空

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False

        self.__front = (self.__front - 1 + self.__capacity) % self.__capacity
        self.__array[self.__front] = value
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        self.__array[self.__rear] = value
        self.__rear = (self.__rear + 1) % self.__capacity
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False

        self.__front = (self.__front + 1) % self.__capacity
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        self.__rear = (self.__rear - 1 + self.__capacity) % self.__capacity
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.__array[self.__front]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1
        return self.__array[(self.__rear - 1 + self.__capacity) % self.__capacity]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.__front == self.__rear

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return (self.__rear + 1) % self.__capacity == self.__front


if __name__ == '__main__':
    myci = MyCircularDeque(7)
    myci.insertFront(10)
    myci.insertFront(11)
    myci.insertFront(12)
    myci.insertFront(13)
    myci.insertFront(14)
    myci.insertFront(15)
    myci.insertLast(16)
    myci.insertLast(17)
    myci.deleteFront()
    myci.insertLast(17)
    myci.insertLast(142)

    print(myci._MyCircularDeque__array)
