"""
    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    求在该柱状图中，能够勾勒出来的矩形的最大面积。

    示例:
        输入: [2,1,5,6,2,3]
        输出: 10
"""
from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        pass

    @classmethod
    def directly_2(cls, heights: List[int]) -> int:
        """
            暴力求解法，三层循环嵌套。
            第一层控制柱子的遍历。
            第二层控制柱子往由遍历
            第三层控制第一层循环的所在的柱子和第二层循环所在的柱子中间的最小值获取。
            然后依次更新外层公用的面积

            时间复杂度:O(n^3)， 空间复杂度O(1)
        """
        res = 0
        height_len = len(heights)

        for i in range(height_len):  # 第一层循环用于遍历每个柱子
            for j in range(i, height_len):
                min_height = float("inf")
                for k in range(i, j + 1):
                    print(k)
                    min_height = min(heights[k], min_height)
                res = max(res, min_height * (j - i + 1))
        return res

    @classmethod
    def directly_1(cls, heights: List[int]) -> int:
        """
            暴力求解法
            两层循环
            第一层循环控制柱子的遍历，
            第二层循环依次往右边遍历，并且计算出每次遍历时的最大面积。
            和暴力求解法1不同的时，不用去找两根柱子之间的最小柱子，用一个变量保存这次循环时，最小柱子的高度。
            时间复杂度O(n^2)，空间复杂度O(1)
        """
        heights_len = len(heights)
        res = 0
        for index in range(heights_len):
            min_height = float("inf")
            for tmp_index in range(index, heights_len):
                min_height = min(min_height, heights[tmp_index])
                res = max(res, min_height * (tmp_index - index + 1))
        return res

    @classmethod
    def divide(cls, heights: List[int]) -> int:
        """
            分治法
            确定了最矮柱子以后，矩形的宽尽可能往两边延伸。
            在最矮柱子左边的最大面积矩形（子问题）。
            在最矮柱子右边的最大面积矩形（子问题）。

            时间复杂度 平均开销：O(nlogn) 最坏O(n^2)
            空间复杂度 O(n)
            FIXME: 还是不太理解，先敲一遍
        """

        def _divide(nums: List[int], start: int, end: int) -> int:
            if start > end:
                return 0

            min_index = start
            for i in range(start, end + 1):
                if nums[min_index] > nums[i]:
                    min_index = i

            check_value = max(_divide(nums, start, min_index - 1), _divide(nums, min_index + 1, end))
            return max(check_value, nums[min_index] * (end - start + 1))

        return _divide(heights, 0, len(heights) - 1)

    @classmethod
    def use_stack(cls, heights: List[int]) -> int:
        """
            使用栈的数据结构（单调递增栈）
            1. 先判断栈是否为空
            2.
        """
        stack = []

        res = 0
        for index in range(len(heights)):
            if not stack:
                stack.append(index)
            else:
                if heights[index] < heights[stack[-1]]:
                    # 说明已经找到了右边界，然后依次弹出栈顶元素 并且计算该元素的最大面积
                    while True:
                        tmp_index = stack.pop()
                        print(tmp_index, "ffff", heights[tmp_index], index - tmp_index + 1)

                        res = max(res, heights[tmp_index] * (index - tmp_index + 1))
                        if not stack:
                            break
                    stack.append(index)
                else:
                    stack.append(index)
        return res


if __name__ == '__main__':
    print(Solution.use_stack([2, 1, 5, 6, 2, 3]))
