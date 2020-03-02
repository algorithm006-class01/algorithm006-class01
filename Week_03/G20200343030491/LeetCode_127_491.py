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