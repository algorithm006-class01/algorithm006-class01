"""
    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

    示例 1:
        输入: [2,3,-2,4]
        输出: 6
        解释: 子数组 [2,3] 有最大乘积 6。
    示例 2:
        输入: [-2,0,-1]
        输出: 0
        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
"""
from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        return self.dp_2(nums)

    @classmethod
    def dp_1(cls, nums: List[int]) -> int:
        """
            时间复杂度：O(n)
            空间负载度：O(1)

        """
        nums_len = len(nums)
        min_dp = [0] * nums_len
        max_dp = [0] * nums_len

        for index, row in enumerate(nums):
            if index == 0:
                min_dp[index] = row
                max_dp[index] = row
            else:
                min_dp[index] = min(max_dp[index - 1] * row, row, min_dp[index - 1] * row)
                max_dp[index] = max(max_dp[index - 1] * row, row, min_dp[index - 1] * row)
        return max(max_dp)

    @classmethod
    def dp_2(cls, nums: List[int]) -> int:
        """
            滚动变量优化，不需要dp数组
            时间复杂度：O(n)
            空间复杂度：O(1)

        """
        assert nums
        min_info = max_info = 1
        res = float("-inf")

        for num in nums:
            if num < 0:
                min_info, max_info = max_info, min_info
            min_info = min(num, min_info * num)
            max_info = max(num, max_info * num)
            res = max(res, max_info)
        return res


if __name__ == '__main__':
    print(Solution.dp_1([2, 3, -2, 4]))
