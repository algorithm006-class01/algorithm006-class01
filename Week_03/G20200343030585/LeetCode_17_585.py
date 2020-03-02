#
# @lc app=leetcode.cn id=17 lang=python
#
# [17] 电话号码的字母组合
# 解题思路
# 1. 回溯
#   1. 

# @lc code=start
class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        if len(digits) == 0:
            return []
        
        res = []
        d = {
            '2':'abc',
            '3':'def',
            '4':'ghi',
            '5':'jkl',
            '6':'mno',
            '7':'pqrs',
            '8':'tuv',
            '9':'wxyz'
        }
        
        nums = [x for x in digits if x in d]
        
        def combine(ret, next_digits):
            # terminator
            if len(next_digits) == 0:
                res.append(ret)
                return
            for i in d[next_digits[0]]:
                combine(ret + i, next_digits[1:])
                
        combine("", nums)
        
        return res
        
# @lc code=end

