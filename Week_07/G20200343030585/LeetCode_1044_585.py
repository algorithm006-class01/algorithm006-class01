# -*- coding:utf-8 -*-

# @lc app=leetcode.cn id=1044 lang=python
#
# [1044] 最长重复子串
#
# 
# 题目
# 求大字符串里面的重复出现的最长子串的所有出现第一个位置（过滤敏感词）
# 用例1：输入：ABCABC 输出：0，3
# 用例2：输入：ABC， 输出：NULL

# 解题思路
# 1.两遍循环
#   1.使用字典记录所有有重复的子串，记录重复出现
#   2.递归查找，比对子串和原字符串，找到所有重复子串
# 
# @lc code=start
class Solution(object):
    def longestDupSubstring(self, S):
        """
        :type S: str
        :rtype: str
        """
        ans = ""
        n = len(S)
        max_len = 0
        max_str = ""
        
        if not S:
            return ans
        
        for i in range(0, n):
            for j in range(i+1, n):
                w = S[i:j]
                
                if w not in S[j+1:]:
                    break
                
                length = len(w)
                if max_len < length:
                    max_len = length
                    max_str = w
        return max_str
        
 


if __name__ == "__main__":
    obj = Solution()
    # ret = obj.longestDupSubstring("ABCABCABC")
    ret = obj.longestDupSubstring("banana")

    print(ret)
# @lc code=end

