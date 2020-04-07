"""
    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    示例 1：
        输入: "Hello"
        输出: "hello"

    示例 2：
        输入: "here"
        输出: "here"
    示例 3：
        输入: "LOVELY"
        输出: "lovely"
"""


class Solution:
    def toLowerCase(self, str: str) -> str:
        """:argument
            ascii码表 https://tool.oschina.net/commons?type=4
            a 97
            A 65
        """
        res = ""
        for index, char in enumerate(str):
            if ord("A") <= ord(char) <= ord("Z"):
                tmp_res = chr(ord(char) + 32)
            else:
                tmp_res = char
            res += tmp_res
        return res


if __name__ == '__main__':
    print(Solution().toLowerCase("al&phaBET"))
