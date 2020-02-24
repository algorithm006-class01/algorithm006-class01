#
# @lc app=leetcode id=66 lang=python
#
# [66] Plus One
# 1. Check the final digit firstly, then process x99 case by converting into string
# 2. Convert into string -> integer value + 1-> string -> integer value
# 3. Check every digits

# @lc code=start

# First
# class Solution(object):
#     def plusOne(self, digits):
#         """
#         :type digits: List[int]
#         :rtype: List[int]
#         """
#         # most simple case
#         if digits[-1] < 9:
#             digits[-1] += 1
#             return digits
#         else:
#             num_digits = len(digits)
#             sum = 0
#             i = num_digits - 1
#             j = 0
#             while i >= 0:
#                 sum += digits[j] * pow(10,i)
#                 i -= 1
#                 j += 1
#             sum += 1
#             new_digits = [int(e) for e in list(str(sum))]
#             return new_digits

# Second
# class Solution(object):
#     def plusOne(self, digits):
#         """
#         :type digits: List[int]
#         :rtype: List[int]
#         """
#         return [int(j) for j in list(str(int(''.join([str(i) for i in digits])) + 1))]

# Third
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        digits[-1] += 1
        for i in range(len(digits)-1,0,-1):
            if digits[i] != 10:
                break
            else:
                digits[i-1], digits[i] = digits[i-1] + 1, 0
        if digits[0] == 10:
            digits[0] = 0
            digits = [1] + digits
        return digits
# @lc code=end

