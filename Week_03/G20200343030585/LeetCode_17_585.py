#
# @lc app=leetcode.cn id=17 lang=python
#
# [17] 电话号码的字母组合
# 解题思路
# 1. 回溯
#   1. 设置字典转化所有可能的数字和字母关系
#   2. 递归当前数字的每个字母，然后把上一次的结果加上这次的结果，再钻到下一层
#   3. 当第一个字母的元素都递归后，再递归第二个字母的元素，依次到最后一个字母
#   这递归过程就是回溯，因为，当前层的递归数据不会在循环里面累加，就是
#   不会出现ab bc de这样连续的情况

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

