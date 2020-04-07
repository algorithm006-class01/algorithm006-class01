"""
    给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

    示例 1：
        输入："ab-cd"
        输出："dc-ba"
    示例 2：
        输入："a-bC-dEf-ghIj"
        输出："j-Ih-gfE-dCba"
    示例 3：
        输入："Test1ng-Leet=code-Q!"
        输出："Qedo1ct-eeLg=ntse-T!"
"""


class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        sl = list(S)
        start = 0
        end = len(sl) - 1

        while start <= end:
            if self.check_is_letter(S[start]) and self.check_is_letter(S[end]):
                # 两个都是字母 就交换
                sl[start], sl[end] = sl[end], sl[start]
                start += 1
                end -= 1
            elif self.check_is_letter(S[start]) and not self.check_is_letter(S[end]):
                end -= 1
            else:
                start += 1
        return ''.join(sl)

    @classmethod
    def check_is_letter(cls, s: str) -> bool:
        return "a" <= s <= "z" or "A" <= s <= "Z"
