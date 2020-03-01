#
# @lc app=leetcode.cn id=433 lang=python
#
# [433] 最小基因变化
#
# 解题思路
# 1.BFS 通过几步能找到你需要的元素
#   1.而广度遍历是不断构建每层的可能性，然后搜索这层的下一层是否满足,只要找到满足就停止
#   2.同时需要保证每次先进入的孩子，优先被弹出，然后检查它的下一层是否满足，只有这样才能保证检查的顺序是一层层的
#   3。满足的条件就是当前字符串和变化字符串就差一个元素

# @lc code=start

import collections

class Solution(object):
    def minMutation(self, start, end, bank):
        """
        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        queue = collections.deque()
        queue.append([start, start, 0]) # current , previous, step
        
        while queue:
            current, previous, step = queue.popleft()
            if current == end:
                return step
                        
            for string in bank:
                if self.validMutation(current, string) and string != previous:
                    queue.append([string, current, step+1])
                    
        return -1
                
    def validMutation(self, current_gene, next_gene):
        changes = 0
        length = len(current_gene)
        for i in range(length):
            if current_gene[i] != next_gene[i]:
                changes += 1
        return changes == 1
        

#  BFS 简短实现
# class Solution(object):
    
#     def differOne(self, str1, str2):
#         return len([c1 for c1,c2 in zip(str1,str2) if c1 != c2]) <= 1
    
#     def bfs(self, start, end, bank):
#         q = collections.deque()
#         q.append((start, 0)) #(gene, level)
#         while q:
#             g = q.popleft()
#             if g[0] == end:
#                 return g[1]
#             #explore genes reachable from this one
#             ex = [(gx, g[1]+1) for gx,visited in bank.items() if not visited and self.differOne(g[0], gx)]
#             q.extend(ex)
#             for x in ex:
#                 bank[x[0]] = True
#         return -1
    
#     def minMutation(self, start, end, bank):
#         return self.bfs(start, end, {g: False for g in bank})


# @lc code=end

