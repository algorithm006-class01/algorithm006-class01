"""
    给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
        每次转换只能改变一个字母。
        转换过程中的中间单词必须是字典中的单词。

        说明:
        如果不存在这样的转换序列，返回 0。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

    示例 1:
        输入:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]
        输出: 5
        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
             返回它的长度 5。

    示例 2:
        输入:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]
        输出: 0

        解释: endWord "cog" 不在字典中，所以无法进行转换。
"""
from collections import deque
from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        return self.bfs(beginWord, endWord, wordList)

    @classmethod
    def tow_end_bfs(cls, begin_word, end_word, word_list: List[str]) -> int:
        if not (begin_word and end_word and end_word in word_list):
            return 0

        word_dict = dict()
        begin_word_len = len(begin_word)

        for word in word_list:
            for i in range(begin_word_len):
                key = word[:i] + "*" + word[i + 1:]
                word_dict[key] = word_dict.get(key, []) + [word]

        start_queue = [begin_word]
        end_queue = [end_word]
        visited = {}

        res = 1
        while start_queue:
            res += 1
            tmp_queue = []
            for word in start_queue:
                for i in range(begin_word_len):
                    blur_word = word[:i] + "*" + word[i + 1:]
                    for tmp_word in word_dict.get(blur_word, []):
                        if tmp_word in end_queue:
                            return res
                        if tmp_word not in visited and tmp_word not in word_list:
                            visited[tmp_word] = 1
                            if tmp_word in word_list:
                                tmp_queue.append(tmp_word)
            start_queue = tmp_queue

            if len(start_queue) > len(end_queue):
                start_queue, end_queue = end_queue, start_queue

        return 0

    @classmethod
    def bfs(cls, begin_word: str, end_word: str, word_list: List[str]) -> int:
        res = 0
        if begin_word and end_word and end_word in word_list:
            begin_word_len = len(begin_word)
            word_dict = dict()

            for word in word_list:
                for i in range(begin_word_len):
                    key = word[:i] + "*" + word[i + 1:]
                    word_dict[key] = word_dict.get(key, []) + [word]

            queue = deque([(begin_word, 1)])
            visited = {begin_word: True}

            while queue:
                cur_word, cur_res = queue.popleft()

                for i in range(begin_word_len):
                    blur_word = cur_word[:i] + "*" + cur_word[i + 1:]

                    for word in word_dict.get(blur_word, []):

                        if word == end_word:
                            return cur_res + 1

                        if word not in visited:
                            queue.append((word, cur_res + 1))
                            visited[word] = True
        return res
