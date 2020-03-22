class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        if g is None or s is None:
            return 0

        g.sort()
        s.sort()

        gi, si = 0, 0
        while gi < len(g) and si < len(s):
            if g[gi] <= s[si]:
                gi += 1
            si += 1
        return gi


g = [10, 9, 8, 7]
s = [5, 6, 7, 8]
aa = Solution()
print(aa.findContentChildren(g, s))