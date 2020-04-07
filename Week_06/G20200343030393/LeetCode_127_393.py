import string
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

        wordSet = set(wordList)

        def nextWords(word, visited):
            for i in range(len(word)):
                for c in string.ascii_lowercase:
                    nextWord = word[:i] + c + word[i + 1:]
                    if nextWord in wordSet and nextWord not in visited:
                        yield nextWord

        beginQueue = collections.deque([(beginWord)])
        endQueue = collections.deque([(endWord)])

        beginVisited, endVisited = set([beginWord]), set([endWord])
        step = 1
        while beginQueue and endQueue:
            newQueue = beginQueue
            beginQueue = collections.deque()
            while newQueue:
                word = newQueue.popleft()
                for nextWord in nextWords(word, beginVisited):
                    if nextWord in endQueue:
                        return step + 1
                    beginQueue.append(nextWord)
                    beginVisited.add(nextWord)
            step += 1
            beginQueue, endQueue = endQueue, beginQueue
            beginVisited, endVisited = endVisited, beginVisited
        return 0


beginWord = "hit"
endWord = "cog"
wordList = ["hot", "dot", "dog", "lot", "log", "cog"]

aa = Solution()
print(aa.ladderLength(beginWord, endWord, wordList))
