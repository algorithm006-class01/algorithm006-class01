"""
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:
        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。

    示例 2:
        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。
"""

from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        return self.tail_loop(digits)

    @classmethod
    def tail_loop(cls, digits: List[int]) -> List[int]:
        """
            从尾部开始循环遍历。
            对应下标元素的值加1，然后对10取模得到一个一个新值。
            如果这个新值不等于0，则说明不用往后循环了，直接返回就行。否则持续这个循环。
            TODO: 如果循环结束函数依然没有返回，则是99， 999， 9999...这种的值，所以要在最前面的一位加1。
            时间复杂度：O(n), 空间复杂度：O(1)
        """
        for index in range(len(digits) - 1, -1, -1):
            digits[index] = (digits[index] + 1) % 10
            if digits[index]:
                return digits
        digits.insert(0, 1)
        return digits

    @classmethod
    def python_trick(cls, digits: List[int]) -> List[int]:
        return [int(i) for i in str(int(''.join(map(str, digits))) + 1)]
