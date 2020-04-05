"""
    给定一个字符串，逐个翻转字符串中的每个单词。
    示例 1：
        输入: "the sky is blue"
        输出: "blue is sky the"

    示例 2：
        输入: "  hello world!  "
        输出: "world! hello"
        解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

    示例 3：
        输入: "a good   example"
        输出: "example good a"
        解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 
    说明：
        无空格字符构成一个单词。
        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
"""


class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        size = len(s)
        i = size - 1
        j = size
        res = ""

        while i >= 0:
            if s[i] == " ":
                res += s[i + 1:j] + " "
                # 跳出空格到上一个单词
                while s[i] == " ":
                    i -= 1
                j = i + 1
            i -= 1

        # 因为最后一个单词没有空格，如果这里面不加这个j的话，则会漏掉最后一个单词
        return res + s[:j]


if __name__ == '__main__':
    print((Solution().reverseWords("the sky is blue"), 1))
