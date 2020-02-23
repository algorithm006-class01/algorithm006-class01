#
# @lc app=leetcode.cn id=46 lang=python
#
# [46] 全排列
# 解题思路
# 1. 暴力
#   1.递归+循环
# 复杂性分析
# 时间复杂度：o(∑k=1 N P(N,k))， P(N, k) = N!/(N−k)! ​=N(N−1)...(N−k+1)，该式被称作 n 的 k-排列，或者_部分排列_.
# 为了简单起见，使 first + 1 = kfirst+1=k.
# 这个公式很容易理解：对于每个 k (每个firstfirst), 有 N(N - 1) ... (N - k + 1)N(N−1)...(N−k+1) 次操作，
# 且 k 的范围从 1 到 N (firstfirst 从 0 到 N - 1).
# 即算法比 O(N×N!)更优 且比 O(N!) 稍慢.
# 空间复杂度：o(N!) 由于必须要保存N! 个解。

# @lc code=start
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if not nums:
            return []
        res = []
        self.recur(nums, 0, len(nums), res)
        return res
        
    def recur(self, nums, first, length, res):
        if first == length:
            res.append(nums[:]) # 一个坑记录下，必须要用:符号，要不添加的就是空
            return res
        
        for i in range(first, length):
            nums[i], nums[first] = nums[first], nums[i]
            self.recur(nums, first + 1, length, res)
            nums[first], nums[i] = nums[i], nums[first]

        
# @lc code=end

