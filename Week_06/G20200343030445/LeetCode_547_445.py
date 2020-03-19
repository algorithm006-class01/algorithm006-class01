#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#

# @lc code=start
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M or len(M) == 0:
            return 0
        
        n = len(M)
        p = [i for i in range(n)]

        def union(i, j):
            p1 = parent(i)
            p2 = parent(j)
            p[p1] = p2
        
        def parent(i):
            root = i
            while p[root] != root:
                root = p[root]
            while p[i] != i:
                x = i; i = p[i]; p[x] = root
            return root

        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    union(i, j)
        
        return len([i for i in range(n) if p[i] == i])
                    
        
# @lc code=end

