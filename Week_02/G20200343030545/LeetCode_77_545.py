"""
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

    示例:

    输入: n = 4, k = 2
    输出:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
"""

from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        if n > 0 and k <= n:
            self.recursive(1, k, n, [], res)

        return res

    @classmethod
    def recursive(cls, start: int, k: int, n: int, pre: List[int], res: List[List[int]]):
        """
            时间复杂度: O(kC k/n) 空间复杂度：O(C)

        """
        # 递归的终止条件
        if len(pre) == k:
            res.append(pre[:])
            return
        for i in range(start, n + 1):
            # 业务逻辑
            pre.append(i)

            # 递归下沉
            cls.recursive(i + 1, k, n, pre, res)

            # 处理业务状态  FIXME 这里不太理解为什么要pop
            pre.pop()

    @classmethod
    def loop(cls, n, k):
        """不理解 多练习几遍"""
        # init first combination
        nums = list(range(1, k + 1)) + [n + 1]
        output, j = [], 0
        while j < k:
            # add current combination
            output.append(nums[:k])
            # increase first nums[j] by one
            # if nums[j] + 1 != nums[j + 1]
            j = 0
            while j < k and nums[j + 1] == nums[j] + 1:
                nums[j] = j + 1
                j += 1
            nums[j] += 1
        return output


if __name__ == '__main__':
    print(Solution.loop(4, 2))
