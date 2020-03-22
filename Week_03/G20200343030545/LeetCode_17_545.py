"""
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    示例:
        输入："23"
        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

"""
from typing import List


class Solution:
    mobile = {
        "2": "abc",
        "3": "def",
        "4": "ghi",
        "5": "jkl",
        "6": "mno",
        "7": "pqrs",
        "8": "tuv",
        "9": "wxyz",
    }

    def letterCombinations(self, digits: str) -> List[str]:
        """
            时间复杂度：O(3**n * 4 ** m)
            空间复杂度：O(3**n * 4 ** m)
        """

        res = []
        if digits:
            self.recursive(0, "", res, digits)
        return res

    @classmethod
    def recursive(cls, index: int, s: str, res: List[str], digits: str):
        if index == len(digits):
            res.append(s)
            return

        for letter in cls.mobile[digits[index]]:
            cls.recursive(index + 1, s + letter, res, digits)


if __name__ == "__main__":
    print(Solution().letterCombinations("23"))
