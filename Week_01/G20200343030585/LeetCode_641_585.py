# -*- coding:utf-8 -*-

# 解题思路
# 循环双端队列可以理解一个两端都可以插入删除的队列，同时队列的指针可以从存储结构的尾部走到头部
# 队列会有两个指针一个指向头部元素，一个指向尾部元素的后一位
# 判断队列为空需要将判断两个指针是否指向同一个位置，为避免队列为满的时候也出现这种情况，队列中多增加一个占位元素
# 插入一个元素，从前端插入需要计算指针的位置，就是从队头部增加，考虑存在循环的情况，所以要模上存储的大小
# 队尾指针始终未最后一个元素+1的位置
# 获取队头元素和队尾元素并不影响指针的位置，只返回值就可以

class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.front = 0 # front始终指向第一个元素的位置
        self.rear = 0        
        self.capacity = k + 1 # 多出来一个是为了保证空和满的判断不冲突
        self.a = [0 for _ in range(self.capacity)]

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.front = (self.front - 1 + self.capacity) % self.capacity
        self.a[self.front] = value
        return True
        

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.a[self.rear] = value
        self.rear = (self.rear + 1) % self.capacity
        return True

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.front = (self.front + 1) % self.capacity
        return True
        

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.rear = (self.rear - 1 + self.capacity) % self.capacity
        return True
        

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.a[self.front]
        
        
    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.a[(self.rear - 1 + self.capacity) % self.capacity]


    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        return self.rear == self.front
        

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return (self.rear + 1) % self.capacity == self.front
    
    def __str__(self):
        return " ".join([str(x) for x in self.a])
            
            
        

if __name__ == "__main__":
    obj = MyCircularDeque(3)
    param_1 = obj.insertFront(1)
    param_2 = obj.insertLast(2)
    param_2 = obj.insertLast(3)
    param_2 = obj.insertLast(4)

    param_6 = obj.getRear()

    param_3 = obj.isFull()
    print(param_3)

    param_4 = obj.deleteLast()

    param_5 = obj.getFront()
    param_7 = obj.isEmpty()

    param_8 = obj.isFull()
    print(param_8)


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