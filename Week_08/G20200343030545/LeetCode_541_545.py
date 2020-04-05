"""
    给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
    如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

    示例:
        输入: s = "abcdefg", k = 2
        输出: "bacdfeg"
        要求:

        该字符串只包含小写的英文字母。
        给定字符串的长度和 k 在[1, 10000]范围内。
"""


class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        """每隔k个反转k个，末尾不够k个时全部反转"""
        return self.solve_2(s, k)

    @classmethod
    def solve_2(cls, s: str, k: int) -> str:
        s_list = list(s)
        for i in range(0, len(s_list), 2 * k):
            s_list[i:i + k] = reversed(s_list[i:i + k])
        return ''.join(s_list)

    @classmethod
    def solve_1(cls, s: str, k: int) -> str:
        s_list = list(s)

        ans = []
        i = 0

        while i * k < len(s_list):
            tmp = s_list[i * k:(i + 1) * k]
            tmp.reverse()
            ans += tmp
            ans += s_list[(i + 1) * k:(i + 2) * k]
            i += 2
        return ''.join(ans)


if __name__ == '__main__':
    Solution().reverseStr("abcdefg", 2)
