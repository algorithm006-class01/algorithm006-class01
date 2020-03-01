#
# @lc app=leetcode id=77 lang=python
#
# [77] Combinations
# 1. f(k) = f(k-1) + f(1) brute force O(N^3)
# 2. backtrack + pruning
# @lc code=start
class Solution(object):
    def __init__(self):
        self.output = []
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if n < 0 or k > n or k < 0:
            return []
        def backtrack(first, curr):
            # has found k numbers, add to output
            if len(curr) == k:
                self.output.append(curr[:])
                return
            # pruning: n - (k - len(curr)) + 1 = max(i)
            for i in range(first,n - (k - len(curr)) + 2):
                curr.append(i)
                backtrack(i + 1,curr)
                # reset status
                curr.pop()
        
        backtrack(1,[])
        return self.output

# @lc code=end

