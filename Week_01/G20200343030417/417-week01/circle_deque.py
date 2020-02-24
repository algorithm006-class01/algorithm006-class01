# 设计实现双段队列
# import collections

class MyCircularDeque:
    def __init__(self,k:int):
        self.k = k
        self.q = []

    # 前端插入
    def insertFront(self,value:int) -> bool:
        if len(self.q) < self.k:
            self.q.insert(0,value)
            return True
        return False

    # 后端插入
    def insertLast(self,value:int) -> bool:
        if len(self.q) < self.k:
            self.q += [value]
            return True
        return False

    # 前段删除
    def deleteFront(self) -> bool:
        if self.q:
            self.q.pop(0)
            return True
        return False

    # 后端删除
    def deleteLast(self) -> bool:
        if self.q:
            self.q.pop()
            return True
        return False

    # 获取前端数据
    def getFront(self) -> int:
        if self.q:
            return self.q[0]
        return -1

    # 获取后端数据
    def getRear(self) -> int:
        if self.q:
            return self.q[-1]
        return -1

    # 判断是否已空
    def isEmpty(self) -> bool:
        return len(self.q) == 0

    # 判断是否已满
    def isFull(self) -> bool:
        return len(self.q) == self.k

