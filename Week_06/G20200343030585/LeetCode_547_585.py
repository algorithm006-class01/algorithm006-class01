#
# @lc app=leetcode.cn id=547 lang=python
#
# [547] 朋友圈
#
# 解题思路
# 1、并查集
#   1.首先建立并查集，并添加每位学生
#   2.然后遍历矩阵，找到两两之间的关系，如果是朋友就放到一个集合里
#   3.最后看有多少集合就知道有多少个朋友圈了，是朋友的都在一个集合里面
  
# 对并查集的压缩的理解
#   1.比如有1，2，3，4以类似链表形式一次排列，每个指向上一级
#   2.执行压缩，取出当前 p[i] != i的元素，证明这个元素不是根，那么就把他指向根，p[i] = root
#   3.他的上一级元素呢，他其实是原来p[i]的值为键的那个元素，所以要把原来的p[i]值保留一份
#   4.然后依次loop上述过程，知道到达根为止

# @lc code=start
class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        #边界判断
        if not M:
            return 0
        
        # 特别注意，逻辑不好理解
        def parent(p, i):
            root = i
            while p[root] != root:
                root = p[root]
            while p[i] != i: # 路径压缩 ?
                x = i
                i = p[i]
                p[x] = root 
            return root

                    
        def union(p, i, j):
            p1 = parent(p, i)
            p2 = parent(p, j)
            # 如果是同一个朋友圈（集合）就不用改了
            # 朋友圈矩阵有重复数据，朋友互相指对方为朋友的情况
            if p1 == p2:
                return
            p[p1] = p2
        
        # 构建并查集
        n = len(M)
        unionfind = [i for i in range(n)]
        
        # 遍历M，找到朋友关系
        for i in range(n):
            for j in range(n):
                if M[i][j] == 1 and i != j:
                    union(unionfind, i, j)
        
        count = 0
        for i in range(len(unionfind)):
            if unionfind[i] == i:
                count+=1
        return count

# class unionFind(object):
#     p = None
    
#     def init(self, n): 
#         # for i = 0 .. n: p[i] = i; 
#         self.p = [i for i in range(n)] 

#     def union(self, i, j): 
#         p1 = self.parent(i) 
#         p2 = self.parent(j) 
#         self.p[p1] = p2 
    
#     def parent(self, i):
#         p = self.p
#         root = i 
#         while p[root] != root: 
#             root = p[root] 
#         while p[i] != i: # 路径压缩 ?
#             x = i; i = p[i]; p[x] = root 
#         return root
    
#     def __len__(self):
#         count = 0
#         for i in range(len(self.p)):
#             if i == self.parent(i):
#                 count += 1
#         return count

# class Solution(object):
#     def findCircleNum(self, M):
#         """
#         :type M: List[List[int]]
#         :rtype: int
#         """
#         #边界判断
#         if not M:
#             return 0
        
#         # 构建并查集
#         n = len(M)
#         unionfind = unionFind(n)
        
#         # 遍历M，找到朋友关系
#         for i in range(n):
#             for j in range(n):
#                 if M[i][j] == 1 and i != j:
#                     unionfind.union(i,j)
        
#         return len(unionfind)
                    
        
        
        
# @lc code=end

