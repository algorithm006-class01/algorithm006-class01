"""
    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2。

    示例:

        输入: [1,8,6,2,5,4,8,3,7]
        输出: 49
"""

from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        pass

    @classmethod
    def directly(cls, height: List[int]) -> int:
        """
            暴力求解法
            两层循环
            第一层循环从0开始到n-1
            第二层循环从第一层循环的下标+1开始到n
            时间负载度O(n^2)，空间复杂度是O(1)
        """
        res = 0
        for i in range(len(height) - 1):
            for j in range(i + 1, len(height)):
                width = min(height[i], height[j])

                length = j - i
                res = max(res, (width * length))
        return res

    @classmethod
    def double_pointer(cls, height: List[int]) -> int:
        """
            双指针解法：
                一个指针从头，一个指针从尾，每次循环计算之间的面积，然后比较双指针所在下标的值的大小。
                哪个小哪个移动。头指针小 头指针+1  尾指针小 尾指针-1
            时间复杂度O(n)，空间复杂度是O(1)
        """
        res = 0

        i = 0
        j = len(height) - 1

        while i < j:
            length = j - i
            width = min(height[j], height[i])

            res = max(res, length * width)

            if height[j] > height[i]:
                i += 1
            else:
                j -= 1

        return res
