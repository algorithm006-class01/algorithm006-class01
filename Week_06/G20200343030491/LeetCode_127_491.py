from collections import defaultdict, deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        size = len(beginWord)
        general_dic = defaultdict(list)

        for word in wordList:
            for i in range(size):
                general_dic[word[:i]+'*'+word[i+1:]].append(word)

        visited = set()
        visited.add(beginWord)
        q = deque()
        q.append((beginWord,1))

        while q:
            cur,lev = q.popleft()
            for i in range(size):
                for distaneOne in general_dic[cur[:i]+'*'+cur[i+1:]]:
                    if endWord == distaneOne:
                        return lev + 1
                    else:
                        if distaneOne not in visited:
                            visited.add(distaneOne)
                            q.append((distaneOne,lev + 1))

        return 0

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque([(beginWord,1)])
        wordList = set(wordList)
        visited = set()
        
        while q:
            word, lev = q.popleft()
            if word == endWord:
                return lev
            
            for char in string.ascii_lowercase:
                for i in range(len(word)):
                    newWord = word[:i] + char + word[i+1:]
                    if newWord in wordList and newWord not in visited:
                        q.append((newWord,lev+1))
                        visited.add(newWord)
                        
        return 0

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
    
        wordList = set(wordList)

        beginQ, endQ = deque([beginWord]), deque([endWord])

        step = 1

        while beginQ:
            nextQ = beginQ
            beginQ = deque([])
            step += 1
            while nextQ:
                word = nextQ.popleft()
                for i in range(len(word)):
                    for c in string.ascii_lowercase:
                        if c != word[i]:
                            nextWord = word[:i]+c+word[i+1:]
                            if nextWord in endQ:
                                return step
                            if nextWord in wordList:
                                beginQ.append(nextWord)
                                wordList.remove(nextWord)

            if len(endQ)<len(beginQ):
                beginQ, endQ = endQ, beginQ

        return 0



class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        if endWord not in wordList:
            return 0

        def nextWords(word,visited):
            for i in range(len(word)):
                for char in string.ascii_lowercase:
                    nextWord = word[:i] + char + word[i+1:]
                    if nextWord in wordList and nextWord not in visited:
                        yield nextWord

        beginQueue, endQueue = deque([beginWord]), deque([endWord])
        beginVisited, endVisited = set([beginWord]), set([endWord])

        step = 1

        while beginQueue and endQueue:
            newQueue = beginQueue
            beginQueue = deque([])
            while newQueue:
                word = newQueue.popleft()
                for nextWord in nextWords(word,beginVisited):
                    if nextWord in endQueue:
                        return step+1

                    beginQueue.append(nextWord)
                    beginVisited.add(nextWord)
            step += 1
            beginQueue, endQueue = endQueue, beginQueue
            beginVisited, endVisited = endVisited, beginVisited
        return 0