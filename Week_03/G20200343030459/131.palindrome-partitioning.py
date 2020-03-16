#
# @lc app=leetcode id=131 lang=python3
#
# [131] Palindrome Partitioning
#
# https://leetcode.com/problems/palindrome-partitioning/description/
#
# algorithms
# Medium (44.66%)
# Likes:    1442
# Dislikes: 55
# Total Accepted:    204.7K
# Total Submissions: 455.4K
# Testcase Example:  '"aab"'
#
# Given a string s, partition s such that every substring of the partition is a
# palindrome.
# 
# Return all possible palindrome partitioning of s.
# 
# Example:
# 
# 
# Input: "aab"
# Output:
# [
# ⁠ ["aa","b"],
# ⁠ ["a","a","b"]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []
        if not s:
            return result
        self.dfs(s, 0, [], result)
        return result
        
    def dfs(self, s, startIndex, substrings, result):
        if startIndex == len(s):
            result.append(substrings[:])
            return

        for i in range(startIndex, len(s)):
            if not self.is_palindrome(s[startIndex:i + 1]):
                continue
            substrings.append(s[startIndex:i + 1])
            self.dfs(s, i + 1, substrings, result)
            substrings.pop()

    def is_palindrome(self, s: str):
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                return False
            left, right = left + 1, right - 1
        return True
        
# @lc code=end

