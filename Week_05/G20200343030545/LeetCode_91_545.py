"""
    一条包含字母 A-Z 的消息通过以下方式进行了编码：
    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    给定一个只包含数字的非空字符串，请计算解码方法的总数。

    示例 1:

        输入: "12"
        输出: 2
        解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

    示例 2:
        输入: "226"
        输出: 3
        解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
"""
from functools import lru_cache


class Solution:
    def numDecodings(self, s: str) -> int:
        return self.dp_1(s)

    @classmethod
    def dp_1(cls, s: str) -> int:
        """
            动态规划dp[i] 为s[:i]解码的总方法数
            分情况建立最优子结构
                当s[i] == 0:
                    dp[i] =  0 if s[i-1] not in ('1', '2') else dp[i-2]
                当s[i-1] ==1:
                    dp[i] = dp[i-1] + dp[i-2]
                当s[i-1]==2 and '1'<=s[i]<='6':
                    dp[i] = dp[i-1] + dp[i-2]

        """
        if s == '0':
            return 0
        s_len = len(s)
        dp = [0] * (s_len + 1)
        dp[0] = 1
        dp[1] = 1

        for index in range(1, s_len):
            if s[index] == "0":
                if s[index - 1] in ("1", "2"):
                    dp[index + 1] = dp[index - 1]
                else:
                    return 0
            else:
                if s[index - 1] == "1":
                    dp[index + 1] = dp[index] + dp[index - 1]
                elif s[index - 1] == "2" and s[index] <= "6":
                    dp[index + 1] = dp[index] + dp[index - 1]
                else:
                    dp[index + 1] = dp[index]
        return dp[s_len]

    @classmethod
    def recursive(cls, s: str):
        s_len = len(s)

        @lru_cache(None)
        def helper(s_index):
            # terminator
            if s_len == s_index:
                # 划分到了最后直接返回1
                return 1
            if s[s_index] == 0:
                # 表示现在这个是以0开头的直接返回0
                return 0

            ans1 = helper(s_index + 1)
            ans2 = 0
            if s_index < s_len - 1:
                # 判断s_index 和 s_index+1之和是否大于26
                first = s[s_index]
                second = s[s_index + 1]

                if int(f"{first}{second}") <= 26:
                    ans2 = helper(s_index + 2)
            return ans1 + ans2

        return helper(0) if s == '0' else 1


if __name__ == '__main__':
    print(Solution().dp_1('01'))
