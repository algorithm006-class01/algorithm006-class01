# -*- coding:utf-8 -*-
# @lc app=leetcode.cn id=151 lang=python
#
# [151] 翻转字符串里的单词
#

# @lc code=start
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return " ".join(reversed(s.split()))
            
        
# @lc code=end
if __name__ == "__main__":
    obj = Solution()
    ret = obj.reverseWords("the sky is blue")
    print(ret)
    
