"""
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

    示例:
        输入: [0,1,0,2,1,0,1,3,2,1,2,1]
        输出: 6
"""
from typing import List


class Stack:
    def __init__(self):
        self.__list = list()

    def peek(self):
        if not self.empty():
            return self.__list[-1]

    def empty(self) -> bool:
        return not bool(self.__list)

    def pop(self) -> bool:
        if self.empty():
            return False
        self.__list.pop()
        return True

    def push(self, v: object) -> bool:
        self.__list.append(v)
        return True

    def __str__(self):
        return "Stack[" + ",".join([str(self.__list[i]) for i in range(len(self.__list) - 1, -1, -1)]) + "]"


class Solution:
    def trap(self, height: List[int]) -> int:
        return self.dp_2(height)

    @classmethod
    def stack_hand(cls, height: List[int]) -> int:
        """
            使用栈处理
            依次入栈：
                1) 当栈为空时，继续入栈
                2) 当栈顶元素小于当前元素时，说明会产生积水，继续入栈
                3) 当栈顶元素大于当前元素时，说明积水停止了。
            时间复杂度：O(n)，空间复杂度：O(n)
        """

        current = 0
        height_len = len(height)
        res = 0
        stack = Stack()

        while current < height_len:
            while not stack.empty() and height[current] > height[stack.peek()]:
                print(current,'ff')
                v = height[stack.peek()]
                stack.pop()
                if stack.empty():
                    break

                distance = current - stack.peek() - 1
                min_v = min(height[stack.peek()], height[current])
                res += (distance * (min_v - v))

            stack.push(current)
            current += 1

        return res

    @classmethod
    def directly(cls, height: List[int]) -> int:
        """
            暴力求解法。计算每一个下标能存储的最大雨滴然后累加。
            详细：
                计算每一列中左边最高的和右边最高的，取两者最小值V和当前列比较。
                1)如果V大雨当前列的值,则可以存放的雨水是当前列和V的差值
                2)如果V等于或者小于当前列，则该列存放的雨水为0。
            时间复杂度：O(n^2)，空间复杂度O(1)
        """
        res = 0

        for i in range(len(height)):
            max_left = max_right = 0
            for j in range(0, i):
                max_left = max(max_left, height[j])

            for k in range(i, len(height)):
                max_right = max(max_right, height[k])

            v = height[i]

            check_v = min(max_left, max_right)

            if check_v > v:
                res += check_v - v
        return res

    @classmethod
    def dp_1(cls, height: List[int]) -> int:
        """
            动态规划求解
                用两个列表存储 左边最大列 右边做大列
                总共3次循环。

                时间复杂度O(n)，空间复杂度O(n)
        """
        res = 0
        height_length = len(height)
        max_left_info = [0] * height_length
        max_right_info = [0] * height_length

        for i in range(1, height_length):
            max_left_info[i] = max(max_left_info[i - 1], height[i - 1])

        for j in range(height_length - 2, -1, -1):
            max_right_info[j] = max(max_right_info[j + 1], height[j + 1])

        for k in range(height_length):
            max_left = max_left_info[k]
            max_right = max_right_info[k]

            v = height[k]
            check_v = min(max_left, max_right)
            if check_v > v:
                res += (check_v - v)
        return res

    @classmethod
    def dp_2(cls, height: List[int]) -> int:
        """
             动态规划求解。
             思路和dp_1 一样，只不过是用两个临时变量保存max_left, max_right
             时间复杂度O(n)，空间复杂度O(1)
        """
        height_len = len(height)
        max_left = max_right = 0
        left = 1
        right = height_len - 2

        res = 0

        for i in range(1, height_len - 1):
            if height[left - 1] < height[right + 1]:
                # 左柱子比右柱子小
                max_left = max(max_left, height[left - 1])

                if max_left > height[left]:
                    res += (max_left - height[left])

                left += 1
            else:
                # 右柱子比左柱子小
                max_right = max(max_right, height[right + 1])

                if max_right > height[right]:
                    res += (max_right - height[right])
                right -= 1

        return res


if __name__ == '__main__':
    print(Solution.stack_hand([2, 1, 2]))
