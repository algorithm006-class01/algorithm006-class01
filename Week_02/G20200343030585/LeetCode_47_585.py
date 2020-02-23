#
# @lc app=leetcode.cn id=47 lang=python
#
# [47] 全排列 II
# 解题思路
# 1.基于全排列1的代码对数据去重,  再做计算
#   1.使用递归和循环计算所有符合可能的结果
#   2.使用回溯查找每个子树里面的可能性
#   3.使用dict来记录每个正确的元素，在添加的时候去重
# 2.思路类似上面，但在可能产生重复的地方剪枝
#   1.
# 
# @lc code=start

class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        if not nums:
            return []
        nums.sort()
        used = [False]*len(nums)
        res, stack = [], []
        self.recur(nums, 0, len(nums), res, stack, used)
        return res
                
    def recur(self, nums, first, length, res, stack, used):
        if first == length:
            res.append(stack[:]) # 一个坑记录下，必须要用:符号，要不添加的就是空
            return
        
        for i in range(length):
            if not used[i]:
                if i > 0 and nums[i] == nums[i - 1] and not used[i-1]:
                    continue
                used[i] = True
                stack.append(nums[i])
                self.recur(nums, first + 1, length, res, stack, used)
                stack.pop()
                used[i] = False
                
    
    
        
# @lc code=end

