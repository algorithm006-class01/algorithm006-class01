#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#
# https://leetcode.com/problems/permutations-ii/description/
#
# algorithms
# Medium (44.12%)
# Likes:    1600
# Dislikes: 56
# Total Accepted:    315.5K
# Total Submissions: 711K
# Testcase Example:  '[1,1,2]'
#
# Given a collection of numbers that might contain duplicates, return all
# possible unique permutations.
# 
# Example:
# 
# 
# Input: [1,1,2]
# Output:
# [
# ⁠ [1,1,2],
# ⁠ [1,2,1],
# ⁠ [2,1,1]
# ]
# 
# 
#

# @lc code=start
# dfs 中的两种条件
# 1: if i != 0 and nums[i] == nums[i - 1]:
#        continue
# 这种是不管什么时候只能选择第一个出现的值
# 2: if i != startIndex and nums[i] == nums[i - 1]
#        continue
# 这种是在同一层循环（dfs）的时候只能选第一个值（不能跳过上一个相同的值选择下一个）
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        visited = [False for i in range(len(nums))]
        if not nums:
            return result
        nums = sorted(nums)
        self.dfs(nums, visited, [], result)
        return result
    
    def dfs(self, nums, visited, permutation, result):
        size = len(nums)
        if len(permutation) == size:
            result.append(permutation[:])
            return
        
        for i in range(size):
            if visited[i]:
                continue
            if i != 0 and nums[i] == nums[i - 1] and not visited[i - 1]:
                continue
            visited[i] = True
            permutation.append(nums[i])
            self.dfs(nums, visited, permutation, result)
            visited[i] = False
            permutation.pop()

# 方法 2： 每次向下传递的时候都把上次加入 permutaion 的值去掉，这样就不用多用一个 visited 数组
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        if not nums:
            return result
        self.dfs(sorted(nums), [], result)
        return result
    def dfs(self, nums, permutation, result):
        if not nums:
            result.append(permutation)
            return
        
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            self.dfs(nums[:i] + nums[i + 1:], permutation + [nums[i]], result)
        


# @lc code=end

