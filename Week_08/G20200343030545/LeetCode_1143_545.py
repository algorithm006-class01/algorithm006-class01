"""
    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
    若这两个字符串没有公共子序列，则返回 0。

    示例 1:
        输入：text1 = "abcde", text2 = "ace"
        输出：3
        解释：最长公共子序列是 "ace"，它的长度为 3。

    示例 2:
        输入：text1 = "abc", text2 = "abc"
        输出：3
        解释：最长公共子序列是 "abc"，它的长度为 3。

    示例 3:
        输入：text1 = "abc", text2 = "def"
        输出：0
        解释：两个字符串没有公共子序列，返回 0。
"""
from functools import lru_cache


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        pass

    @classmethod
    def recursive(cls, text1: str, text2: str) -> int:
        """
            从头开始算
                i 代表text1 的下标
                j 代表text2 的下标

                如果 text1[i] == text2[j] 则结果+1
                否则取 i+1, j   和 i, j+1 这两个结果的最大值。

        """
        text1_len = len(text1)
        text2_len = len(text2)

        @lru_cache(None)
        def helper(i: int, j: int) -> int:
            if i >= text1_len or j >= text2_len:
                return 0
            if text1[i] == text2[j]:
                return helper(i + 1, j + 1) + 1
            return max(helper(i, j + 1), helper(i + 1, j))

        return helper(0, 0)

    @classmethod
    def dp(cls, text1: str, text2: str) -> int:
        """
            i j 不代表下标
            dp[i][j]  代表 text1到i之前 text2到j之前 的最大子序列长度。

            dp[i][j] = dp[i-1][j-1] + 1  if text1[i] == text2[j]
                                or
            dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]

        """
        text1_len = len(text1)
        text2_len = len(text2)

        # 多增加1位 处理边界问题
        dp = [[0 for i in range(text2_len + 1)] for j in range(text1_len + 1)]

        for i in range(text1_len + 1):
            for j in range(text2_len + 1):
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) if text1[i - 1] != text2[j - 1] else dp[i - 1][j - 1] + 1
        return dp[text1_len][text2_len]

if __name__ == '__main__':
    print(Solution().dp("abcde", "ace"))
