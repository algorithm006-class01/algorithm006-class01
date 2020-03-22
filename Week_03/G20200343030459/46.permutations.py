#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#
# https://leetcode.com/problems/permutations/description/
#
# algorithms
# Medium (60.16%)
# Likes:    3151
# Dislikes: 94
# Total Accepted:    525.4K
# Total Submissions: 867.8K
# Testcase Example:  '[1,2,3]'
#
# Given a collection of distinct integers, return all possible permutations.
# 
# Example:
# 
# 
# Input: [1,2,3]
# Output:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        visited = [False for i in range(len(nums))]
        if not nums:
            return nums
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
            visited[i] = True
            permutation.append(nums[i])
            self.dfs(nums, visited, permutation, result)
            visited[i] = False
            permutation.pop()

# @lc code=end

