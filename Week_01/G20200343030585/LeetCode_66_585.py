# -*- coding:utf-8 -*-

# 解题思路
# 1.输入是非负整数组成的数组，每个元素为一个数字
# 2.要求在这个数字上+1，然后再按大小输出到数组，保证在数组里面的顺序是从大到小
# 3.由于只是加一，只需要考虑最后一位+1的情况
#  1. 最后一位非9，+1后直接写入最后一位的值就行
#  2. 最后一位为9，+1后结果为0，需要判断然后进一位+1，这个步骤可以循环
#  3.最后排除数字全是9的情况

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        for i in range(length - 1, -1, -1):
            digits[i] += 1
            digits[i] = digits[i] % 10
            if digits[i] != 0:
                return digits

        digits.insert(0, 1)
        return digits
        
        

if __name__ == "__main__":
    obj = Solution()
    print(obj.plusOne([9,9,9]))