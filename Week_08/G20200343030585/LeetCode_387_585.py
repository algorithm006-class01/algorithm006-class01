# -*- coding:utf-8 -*-
# @lc app=leetcode.cn id=387 lang=python
#
# [387] 字符串中的第一个唯一字符
#

# @lc code=start
from collections import Counter

class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        # cnt = Counter(s)
        # minVal = float('inf')
        # for x,i in cnt.items():
        #     if i == 1:
        #         minVal = min(minVal, s.index(x)) 
        # return minVal if minVal != float('inf') else -1
        for c in s:
            if s.find(c) == s.rfind(c):
                return s.find(c)
        return -1
        
# @lc code=end
if __name__ == "__main__":
    obj = Solution()
    ret = obj.firstUniqChar("loveleetcode")
    print(ret)
    ret = obj.firstUniqChar("cc")
    print(ret)
    ret = obj.firstUniqChar("")
    print(ret)
    ret = obj.firstUniqChar("leetcode")
    print(ret)