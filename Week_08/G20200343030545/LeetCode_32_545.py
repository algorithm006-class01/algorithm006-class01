"""
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

    示例 1:
        输入: "(()"
        输出: 2
        解释: 最长有效括号子串为 "()"
    示例 2:
        输入: ")()())"
        输出: 4
        解释: 最长有效括号子串为 "()()"
"""


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        pass

    @classmethod
    def use_stack(cls, s: str):
        res = 0
        stack = [-1]

        for index, char in enumerate(s):
            print(stack)
            if char == "(":
                stack.append(index)
            else:
                stack.pop()
                if not stack:
                    stack.append(index)
                else:
                    res = max(res, index - stack[-1])
        return res

    @classmethod
    def dp_1(cls, s: str) -> int:
        """
            dp[i] 代表下标为i 结尾的字符中最长的有效字符串长度
            当以"(" 结尾时，不合法，所以不考虑。

            当以")" 结尾时，
                当i-1是"("  dp[i] = dp[i-2] + 2
                当i-1是")" dp[i]  = dp[i-1] + dp[i-dp[i-1] -2] +2
        """
        res = 0
        dp = [0] * len(s)
        for index in range(1, len(s)):
            char = s[index]
            if char == ")":
                if s[index - 1] == "(":
                    dp[index] = dp[index - 2] + 2

                if s[index - 1] == ")" and index - dp[index - 1] - 1 >= 0 and s[index - dp[index - 1] - 1] == "(":
                    dp[index] = dp[index - 1] + dp[index - dp[index - 1] - 2] + 2

            res = max(res, dp[index])
        return res


if __name__ == '__main__':
    print(Solution().use_stack("(()"))
