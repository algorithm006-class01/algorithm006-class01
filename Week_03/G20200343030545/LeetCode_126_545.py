"""
    给定两个单词（beginWord 和 endWord）和一个字典 wordList，
    找出所有从 beginWord 到 endWord 的最短转换序列。
    转换需遵循如下规则：

    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
    说明:
        如果不存在这样的转换序列，返回一个空列表。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

    示例 1:
        输入:
            beginWord = "hit",
            endWord = "cog",
            wordList = ["hot","dot","dog","lot","log","cog"]

        输出:
            [
              ["hit","hot","dot","dog","cog"],
              ["hit","hot","lot","log","cog"]
            ]

    示例 2:
        输入:
            beginWord = "hit"
            endWord = "cog"
            wordList = ["hot","dot","dog","lot","log"]
        输出: []
        解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
"""
from typing import List, Dict


class Solution:
    def __init__(self):
        self.min_info = float("inf")

    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        # res = []
        # if beginWord and endWord and wordList:
        #     self.DFS(beginWord, endWord, wordList, [beginWord], res)
        # return res
        res = []
        if beginWord and endWord and wordList:
            hash_map = {}
            distance_map = {}
            self.BFS(beginWord, endWord, wordList, hash_map, distance_map)
            self.DFS_FIND(beginWord, endWord, hash_map, distance_map, [], res)
        return res

    def BFS(
            self,
            begin_word: str,
            end_word: str,
            word_list: List[str],
            hash_map: Dict[str, List[str]],
            distance_map: Dict[str, int]
    ):
        queue = [begin_word]
        distance_map[begin_word] = 0
        is_found = False
        depth = 0
        word_set = set(word_list)

        while queue:
            queue_size = len(queue)
            depth += 1
            print(queue)
            for i in range(queue_size):
                tmp_word = queue.pop()
                # 得到这个tmp_word下的所有节点
                all_neighbors = self.get_neighbors(tmp_word, word_set)
                hash_map[tmp_word] = all_neighbors
                for neighbor in all_neighbors:
                    if neighbor not in distance_map:
                        distance_map[neighbor] = depth
                        if neighbor == end_word:
                            is_found = True

                        queue.append(neighbor)
            if is_found:
                break

    def DFS(self, begin_word: str, end_word: str, word_list: List[str], tmp_list: List[str], res: List[List[str]]):
        # terminator
        if begin_word == end_word:
            if self.min_info > len(tmp_list):
                res.clear()
                self.min_info = len(tmp_list)
                res.append(tmp_list[:])
            elif self.min_info == len(tmp_list):
                res.append(tmp_list[:])
            return
        if len(tmp_list) > self.min_info:
            return
        # process
        for word in word_list:
            # TODO 如果这个word已经出现过了 并且
            if word in tmp_list:
                continue
            if self.word_changed(begin_word, word):
                tmp_list.append(word)
                # drill down
                self.DFS(word, end_word, word_list, tmp_list, res)
                # reverse state
                tmp_list.pop()

    @classmethod
    def get_neighbors(cls, word: str, word_set: set) -> List[str]:
        res = []
        for tmp_word in word_set:
            if cls.word_changed(word, tmp_word):
                res.append(tmp_word)
        return res

    @classmethod
    def word_changed(cls, word1: str, word2: str) -> bool:
        count = 0
        for index, row in enumerate(word1):
            if row != word2[index]:
                count += 1
            if count == 2:
                break
        return count == 1

    @classmethod
    def DFS_FIND(
            cls,
            begin_word: str,
            end_word: str,
            hash_map: Dict[str, List[str]],
            distance_map: Dict[str, int],
            tmp_list: List[str],
            res: List[List[str]]
    ):
        # terminator
        if begin_word == end_word:
            res.append(tmp_list[:])
            return

        neighbors = hash_map.get(begin_word, [])
        for neighbor in neighbors:
            if distance_map[begin_word] + 1 == distance_map[neighbor]:
                tmp_list.append(neighbor)
                cls.DFS_FIND(neighbor, end_word, hash_map, distance_map, tmp_list, res)
                tmp_list.pop()


if __name__ == "__main__":
    b_w = "hit"
    e_w = "cog"
    w_l = ["hot", "dot", "dog", "lot", "log", "cog"]
    print(Solution().findLadders(b_w, e_w, w_l))
