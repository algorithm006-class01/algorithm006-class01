from collections import defaultdict


class Solution(object):
    def __init__(self):
        self.lenght = 0
        self.all_combo_dict = defaultdict(list)

    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList or not beginWord or not endWord or not wordList:
            return 0

        self.lenght = len(beginWord)
        for word in set(wordList):
            for i in range(self.lenght):
                self.all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

        queue_begin = [(beginWord, 1)]
        queue_end = [(endWord, 1)]

        visited_begin = {beginWord: 1}
        visited_end = {endWord: 1}
        ans = 0

        while queue_begin and queue_end:
            ans = self.visitedWordNode(queue_begin, visited_begin, visited_end)
            if ans:
                return ans

            ans = self.visitedWordNode(queue_end, visited_end, visited_begin)
            if ans:
                return ans
        return ans

    def visitedWordNode(self, queue, visited, orther_cisited):
        current_word, level = queue.pop(0)

        for i in range(self.lenght):
            intermediate = current_word[:i] + "*" + current_word[i+1:]
            for word in self.all_combo_dict[intermediate]:
                if word in orther_cisited:
                    return level + orther_cisited[word]

                if word not in visited:
                    visited[word] = level + 1
                    queue.append((word, level+1))
        return 0


beginWord = "hot"
endWord = "dog"
wordList = ["hot", "dog"]
run = Solution()
print(run.ladderLength(beginWord, endWord, wordList))