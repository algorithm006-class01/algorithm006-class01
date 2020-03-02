#
# @lc app=leetcode id=126 lang=python
#
# [126] Word Ladder II
#

# @lc code=start
from collections import defaultdict
from collections import deque
# bfs, path
# use dict to store every shortest path to the everyword it goes through
class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        if endWord not in wordList:
            return []
        
        ans = []
        wordSet = set(wordList)
        layer = dict()
        layer[beginWord] = [[beginWord]]
        while layer:
            newlayer = defaultdict(list)
            for w in layer:
                if w == endWord:
                    ans.extend(k for k in layer[w])
                else:
                    for i in range(len(w)):
                        for c in "abcdefghijklmnopqrstuvwxyz":
                            s = w[:i] + c + w[i+1:]
                            if s in wordSet:
                                newlayer[s] += [j + [s] for j in layer[w]]
            wordSet -= set(newlayer.keys())
            layer = newlayer            
        return ans
# @lc code=end

