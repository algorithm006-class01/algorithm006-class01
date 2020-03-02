#
# @lc app=leetcode id=127 lang=python
#
# [127] Word Ladder
#

# @lc code=start
import collections
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0

        wordDict = self.constructwordDict(beginWord,wordList)
        return self.bfs(beginWord,wordDict,wordList,endWord)


    def constructwordDict(self,beginWord,wordList):
        TempwordList = [beginWord] + wordList
        wordDict = {}
        n = len(beginWord)
        for word in TempwordList:
            for i in range(n):
                s = word[:i] + "_" + word[i+1:]
                wordDict[s] = wordDict.get(s,[]) + [word]
                
        return wordDict
        
    def bfs(self,beginWord,wordDict,wordList,endWord):
        queue = collections.deque(([(beginWord,1)]))
        visited = set()
        while queue:
            word, step = queue.popleft()
            if word not in visited:
                if word == endWord:
                    return step
                visited.add(word)
                for i in range(len(word)):
                    s = word[:i] + "_" + word[i+1:]
                    neighWords = wordDict.get(s,[])
                    for negihword in neighWords:
                        queue.append((negihword,step + 1))
        return 0

# @lc code=end

