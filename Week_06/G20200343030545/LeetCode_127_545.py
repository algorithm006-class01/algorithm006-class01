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
from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        return self.two_end_bfs(beginWord, endWord, wordList)

    @classmethod
    def two_end_bfs(cls, begin_word, end_word, word_list: List[str]) -> int:
        if begin_word and end_word and end_word in word_list:
            word_dict = dict()
            begin_word_len = len(begin_word)

            for word in word_list:
                for i in range(begin_word_len):
                    key = word[:i] + "*" + word[i + 1:]
                    word_dict[key] = word_dict.get(key, []) + [word]

            begin_word_queue = [begin_word]
            end_word_queue = [end_word]
            visited = set()

            res = 1
            while begin_word_queue:
                tmp_queue = []
                res += 1
                for tmp_word in begin_word_queue:
                    for i in range(begin_word_len):
                        like_word = tmp_word[:i] + "*" + tmp_word[i + 1:]
                        for check_word in word_dict.get(like_word, []):
                            if check_word in end_word_queue:
                                return res
                            if check_word not in visited:
                                visited.add(check_word)
                                tmp_queue.append(check_word)
                begin_word_queue = tmp_queue

                if len(begin_word_queue) > len(end_word_queue):
                    begin_word_queue, end_word_queue = end_word_queue, begin_word_queue
        return 0

    @classmethod
    def bfs(cls, begin_word: str, end_word: str, word_list: List[str]) -> int:
        if end_word and end_word in word_list:
            word_dict = dict()
            begin_word_len = len(begin_word)
            for word in word_list:
                for i in range(begin_word_len):
                    key = word[:i] + "*" + word[i + 1:]
                    word_dict[key] = word_dict.get(key, []) + [word]

            # bfs
            queue = [begin_word]
            visit = {}

            res = 1  # z这里求的是最短路径 包括开始给的begin_word，所以初始res=1
            while queue:
                res += 1
                tmp_queue = []
                for tmp_word in queue:
                    for i in range(begin_word_len):
                        like_word = tmp_word[:i] + "*" + tmp_word[i + 1:]
                        for check_word in word_dict.get(like_word, []):
                            if check_word == end_word:
                                return res
                            if check_word not in visit:
                                visit[check_word] = True
                                tmp_queue.append(check_word)
                queue = tmp_queue
        return 0


if __name__ == '__main__':
    b = "hit"
    e = "cog"
    w = ["hot", "dot", "dog", "lot", "log", "cog"]
    print(Solution.bfs(b, e, w))
