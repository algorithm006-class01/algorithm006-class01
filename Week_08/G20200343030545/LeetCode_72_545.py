"""
    给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

    你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符

    示例 1:
        输入: word1 = "horse", word2 = "ros"
        输出: 3
    解释:
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')

    示例 2:
        输入: word1 = "intention", word2 = "execution"
        输出: 5
    解释:
        intention -> inention (删除 't')
        inention -> enention (将 'i' 替换为 'e')
        enention -> exention (将 'n' 替换为 'x')
        exention -> exection (将 'n' 替换为 'c')
        exection -> execution (插入 'u')
"""


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        pass

    @classmethod
    def solve_1(cls, word1: str, word2: str) -> int:
        """
            dp[i][j] 代表 word1的前i个字符  和 word2的前j个字符 两者之间 转换的最少操作次数
        """
        m = len(word1)
        n = len(word2)

        if m * n == 0:
            # 表示两个单词之中有一个是空
            return m + n

        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]

        for i in range(m+1):
            dp[i][0] = i

        for j in range(n+1):
            dp[0][j] = j

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        return dp[m][n]
