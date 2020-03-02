#
# @lc app=leetcode.cn id=126 lang=python
#
# [126] 单词接龙 II
#
# 解题思路
# 1.广度优先搜索
#   1.构建每个单词的变换链
#   2.跳过已经存在于当前链里面的节点
#   3.跳过已经用过的节点，避免重复逻辑导致无限递归
#   4.加速过程，添加word到word list的映射关系


# @lc code=start
# from collections import deque
# from collections import defaultdict

# class Solution(object):
#     def findLadders(self, beginWord, endWord, wordList):
#         res = []
#         if beginWord == endWord:
#             return []
#         if endWord not in wordList:
#             return []
        
#         queue = deque()
#         queue.append([beginWord, [beginWord]])

        
#         # 构建一个word到word list的映射
#         # for w in wordList:
#         #     for i in range(len(w)):
#         #         word_dict[w[:i] + "*" + w[i+1:]] += [w]
#         # queue.append([beginWord, [beginWord]])
#         while queue:
#             word, level = queue.popleft()
#             if word == endWord:
#                 res.append(level)
#             else:
#                 for i in range(len(word)):
#                     # d = word_dict[word[:i] + '*' + word[i+1:]]
#                     for c in 'abcdefghijklmnopqrstuvwxyz':
#                         newword = word[:i] + c + word[i+1:]
#                         if newword in wordList:
#                             queue.append([newword, level + [newword]])

#         minVal = float('inf')
#         temp = []
#         for i in res:
#             minVal = min(len(i), minVal)
        
#         for i in res:
#             if len(i) == minVal:
#                 temp.append(i)
        
#         return temp
            
import collections

class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):

        wordList = set(wordList)
        res = []
        layer = {}
        layer[beginWord] = [[beginWord]]

        while layer:
            newlayer = collections.defaultdict(list)
            for w in layer:
                if w == endWord: 
                    res.extend(k for k in layer[w])
                else:
                    for i in range(len(w)):
                        for c in 'abcdefghijklmnopqrstuvwxyz':
                            neww = w[:i]+c+w[i+1:]
                            if neww in wordList:
                                newlayer[neww]+=[j+[neww] for j in layer[w]]

            wordList -= set(newlayer.keys())
            layer = newlayer

        return res

# from collections import defaultdict
# from collections import deque


# class Solution(object):
#     def findLadders(self, beginWord, endWord, wordList):
#         """
#         :type beginWord: str
#         :type endWord: str
#         :type wordList: List[str]
#         :rtype: List[List[str]]
#         """
#         res = []
#         if beginWord == endWord:
#             return []
#         if endWord not in wordList:
#             return []

#         # # 由于单词相同，只需要遍历一次就可以了
#         # def changeStep(word1, word2):
#         #     change = 0
#         #     for i in range(len(word1)):
#         #         if word1[i] != word2[i]:
#         #             change+=1
#         #     return change == 1

#         L = len(beginWord)
#         # 通过单词的通用规则比如hit可以变换为h*t,*it,hi* 等情况找到字典里面所有的word对应关系
#         # 这样就可以利用索引的方式来查找结果，时间复杂度O(1),这里的两遍循环的时间复杂度是O(n*m),m为单词的长度
#         all_combo_dict = defaultdict(list)
#         for word in wordList:
#             for i in range(L):
#                 # Key is the generic word
#                 # Value is a list of words which have the same intermediate generic word.
#                 all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

#         # Queue for BFS
#         queue = deque()
#         # current, previous, step
#         queue.append([beginWord, [beginWord]])
#         # 为了防止出现环，使用访问数组记录
#         visited = {beginWord: True}
#         while queue:
#             current, step = queue.popleft()
#             for i in range(L):
#                 intermediate_word = current[:i] + "*" + current[i+1:]

#                 for node in all_combo_dict[intermediate_word]:
#                     if node == endWord:
#                        res.append(step + [endWord])
#                        continue

#                     if node not in visited:
#                         visited[node] = True
#                         queue.append([node, step + [node]])

#                 # 避免重复计算
#                 # all_combo_dict[intermediate_word] = []

#         val = float('inf')
#         ret = []
#         for l in res:
#             val = min(len(l), val)
#             if val == len(l):
#                 ret.append([l,val])

#         return [l for l,v in ret if v==val]
            
        
# @lc code=end

