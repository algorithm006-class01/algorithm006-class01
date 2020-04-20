#
# @lc app=leetcode id=438 lang=python
#
# [438] Find All Anagrams in a String
#

# @lc code=start
#TLE
# class Solution(object):
#     def findAnagrams(self, s, p):
#         """
#         :type s: str
#         :type p: str
#         :rtype: List[int]
#         """
#         if not p or not s or len(p) > len(s):
#             return []
        
#         patHash = 0
#         sHash = 0
#         M = len(p)
#         N = len(s)
#         output = []
#         for i in range(M):
#             patHash += ord(p[i])
#             sHash += ord(s[i])

        
#         for i in range(N-M+1):
#             txt = s[i:i+M]
#             if patHash == sHash:
#                 txt = s[i:i+M]
#                 if sorted(txt) == sorted(p):
#                     output.append(i)
#             if i < N - M:
#                 sHash = sHash - ord(s[i]) + ord(s[i+M])
#         return output

class Solution(object):
    """
        maintain a 26-element array 
        using sliding window to change array
    """
    def countarr(self,w):
            out = [0 for i in range(26)]
            for c in w:
                out[ord(c) - ord('a')] += 1
            return out

    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        if not p or not s or len(p) > len(s):
            return []
        M = len(p)
        N = len(s)
        pp = self.countarr(p)
        ss = self.countarr(s[:M])
        ans = []
        for i in range(N-M+1):
            if pp == ss:
                ans.append(i)
            if i < N - M:
                left = ord(s[i]) - ord('a')
                right = ord(s[i+M]) - ord('a')
                ss[left] -= 1
                ss[right] += 1
        return ans  

        # @lc code=end

