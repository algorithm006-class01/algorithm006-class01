#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList) # speed up!
        if endWord not in wordList:
            return 0
        dictionary = list('abcdefghijklmnopqrstuvwxyz')
        
        q = [(beginWord, 0)]
        while q:
            word, step = q.pop(0)
            if word == endWord:
                return step + 1
            for i in range(len(word)):
                for j in dictionary:
                    new = word[:i] + j + word[i+1:]
                    if new in wordList:
                        q.append((new, step+1))
                        wordList.remove(new)
        return 0


# @lc code=end

