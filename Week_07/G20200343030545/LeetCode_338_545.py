"""
    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

    示例 1:
        输入: 2
        输出: [0,1,1]

    示例 2:
        输入: 5
        输出: [0,1,1,2,1,2]
    进阶:
        给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
        要求算法的空间复杂度为O(n)。
"""
from typing import List


class Solution:
    def countBits(self, num: int) -> List[int]:
        return self.use_iteration(num)

    @classmethod
    def use_iteration(cls, num: int) -> List[int]:

        nums = [0 for i in range(num + 1)]
        for i in range(num):
            nums[i] = cls.helper(i)
        return nums

    @classmethod
    def use_dp(cls, num: int) -> List[int]:
        # https://leetcode-cn.com/problems/counting-bits/solution/dong-tai-gui-hua-wei-yun-suan-xing-zhi-python3-by-/

        dp = [0] * (num + 1)
        for i in range(1, num + 1, ):
            if i % 2 == 1:
                dp[i] = dp[i - 1] + 2
            else:
                dp[i] = dp[i // 2]
        return dp

    @classmethod
    def helper(cls, n: int) -> int:
        res = 0
        while n:
            res += 1
            n &= n - 1
        return res
