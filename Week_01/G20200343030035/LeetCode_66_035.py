# LeetCode #66 加一
# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
# 你可以假设除了整数 0 之外，这个整数不会以零开头。


class Solution:
   def plusOne(self, digits):
       carry = 0
       digits[len(digits)-1] += 1
       for i in range(len(digits)-1,-1,-1):
           digits[i] += carry
           if digits[i] > 9 :
               carry = 1
               digits[i] = 0
           else:
               carry = 0
       if carry == 1:
           digits = [1] + digits
       res = ''
       for i in range(len(digits)-1,-1,-1):
           res = str(digits[i]) + res
       return(res)