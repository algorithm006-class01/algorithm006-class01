"""
    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

    若这两个字符串没有公共子序列，则返回 0。

    示例 1:
        输入：text1 = ""abcde"", text2 = "ace"
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
 
    提示:
        1 <= text1.length <= 1000
        1 <= text2.length <= 1000
    输入的字符串只含有小写英文字符。
"""
from functools import lru_cache


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return self.dp_1(text1, text2)
        # return self.recursive(text1, text2, len(text1) - 1, len(text2) - 1)

    @classmethod
    def dp_1(cls, text1: str, text2: str) -> int:
        """
            定义一个二维数组dp用来存储最长公共子序列的长度。
            其中dp[i][j] 表示text1的前i个字符与text2的前j个字符的最长公共子序列的长度。

            从text1和text2的后面开始分析
                1. 当text1[i] == text2[j]时，那么最长公共子序列的长度就应该是
                text1前i-1个字符与text2前j-1个字符最长公共子序列的长度+1。 即1+ dp[i-1][j-1]

                2. 当text1[i] != text2[j]时，那么最长公共子序列的长度就应该是
                text1前i-1个字符的和text2前j个字符的最长公共子序列  和  text1中前i个字符和text2前j个字符的最长公共子序列中的最大值。
                即 Max(dp[i-1][j], dp[i][j-1])
            所以状态转移方程是：
                dp[i][j] = dp[i-1][j-1] + 1    if   text[i] == text[j] else max(dp[i-1][j], dp[i][j-1])

            时间复杂度：O(m*n)
            空间复杂度：O(m*n)
        """
        res = 0

        if text1 and text2:
            m = len(text1) + 1
            n = len(text2) + 1

            dp = [[0] * n for i in range(m)]

            for i in range(1, m):
                for j in range(1, n):
                    dp[i][j] = dp[i - 1][j - 1] + 1 if text1[i - 1] == text2[j - 1] else max(dp[i - 1][j], dp[i][j - 1])
            res = dp[m - 1][n - 1]
        return res

    @classmethod
    @lru_cache(None)  # None 表示 不限制 缓存本身的大小，如果不设置默认是128
    def recursive(cls, text1, text2, i, j):
        """
            时间复杂度：O(m*n)
            空间复杂度：O(m*n)

        """
        if i < 0 or j < 0:
            return 0
        if text1[i] == text2[j]:
            return cls.recursive(text1, text2, i - 1, j - 1)
        return max(cls.recursive(text1, text2, i, j - 1), cls.recursive(text1, text2, i, j - 1))
