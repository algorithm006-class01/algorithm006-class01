"""
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    示例:

        输入: [-2,1,-3,4,-1,2,1,-5,4],
        输出: 6
        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    进阶:
        如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
"""
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        return self.directly(nums)

    @classmethod
    def directly(cls, nums: List[int]) -> int:
        """
            时间复杂度：O(n^2)
            空间复杂度：O(1)
            这个解法会超时😂
        """
        max_num = float("-inf")
        len_num = len(nums)

        for index in range(len_num):
            tmp_max_num = 0
            for tmp_index in range(index, len_num):
                tmp_max_num += nums[tmp_index]
                if tmp_max_num > max_num:
                    max_num = tmp_max_num
        return max_num

    @classmethod
    def dp_1(cls, nums: List[int]) -> int:
        """
            状态转移方程：
                最大子序列 = 当前元素自身最大  或者 包含之前的最大
                dp[i] = max(nums[i], nums[i]+dp[i-1])
            时间复杂度：O(n)
            空间复杂度：O(n)
        """
        dp = [0] * len(nums)
        for index, num in enumerate(nums):
            if index == 0:
                dp[index] = num
            else:
                dp[index] = max(num, num + dp[index - 1])
        return max(dp)

    @classmethod
    def dp_2(cls, nums: List[int]) -> int:
        """
            状态转移方程同上
            只不过是复用nums（但是会改变nums本身的元素）
            时间复杂度：O(n)
            空间复杂度：O(1)
        """
        for index, num in enumerate(nums):
            if index == 0:
                continue
            nums[index] = max(num, nums[index - 1] + num)
        return max(nums)


if __name__ == '__main__':
    print(Solution().dp_1([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
