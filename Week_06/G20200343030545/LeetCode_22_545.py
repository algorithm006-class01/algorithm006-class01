"""
    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
    例如，给出 n = 3，生成结果为：

    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
"""

from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        return self.dp(n)

    @classmethod
    def dfs(cls, n: int) -> List[str]:

        def helper(left_index: int, right_index: int, need_n: int, tmp_str: str, tmp_res: List[str]) -> None:
            # terminator
            if left_index == right_index == need_n:
                tmp_res.append(tmp_str)
                return
            # process
            if left_index < n:
                # drill down
                helper(left_index + 1, right_index, need_n, tmp_str + "(", tmp_res)
            if right_index < left_index:
                # drill down
                helper(left_index, right_index + 1, need_n, tmp_str + ")", tmp_res)

        res = []
        helper(0, 0, n, "", res)
        return res

    @classmethod
    def dp(cls, n: int) -> List[str]:
        """
            #TODO 没有理解 先过编数

            dp[i] 表示 使用 i 对括号能够生成的组合
            状态转移方程：
                dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
        """
        res = []
        if n:
            dp = [[] for i in range(n + 1)]
            dp[0] = [""]

            for i in range(1, n + 1):
                cur = []
                for j in range(i):
                    left = dp[j]
                    right = dp[i - j - 1]
                    for s1 in left:
                        for s2 in right:
                            cur.append("(" + s1 + ")" + s2)
                dp[i] = cur
            res = dp[n]
        return res
