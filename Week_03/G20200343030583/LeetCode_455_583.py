#
# @lc app=leetcode id=455 lang=python
#
# [455] Assign Cookies
#

# @lc code=start
class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        if len(s) == 0:
            return 0
        #.sort() is faster than sorted()
        s.sort()
        g.sort()
        count = 0
        i,j = 0,0
        while i < len(s) and j < len(g):
            if s[i] >= g[j]:
                count += 1
                i += 1
                j += 1
            else:
                i += 1
        return count
# @lc code=end

