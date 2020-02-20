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


if __name__ == '__main__':
    print(Solution().combine(4, 2))
