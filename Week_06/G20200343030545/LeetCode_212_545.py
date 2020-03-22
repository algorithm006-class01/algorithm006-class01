"""
    给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母在一个单词中不允许被重复使用。

    示例:

    输入:
        words = ["oath","pea","eat","rain"] and board =
        [
          ['o','a','a','n'],
          ['e','t','a','e'],
          ['i','h','k','r'],
          ['i','f','l','v']
        ]

    输出: ["eat","oath"]
    说明:
    你可以假设所有输入都由小写字母 a-z 组成。

    提示:
        你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
        如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。
        什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
        前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
"""
from typing import List, Dict


class Solution:
    TRIE_END_CHAR = "#"
    DIRECTION_SET = ((1, 0), (-1, 0), (0, -1), (0, 1))  # 代表上下左右

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = self.build_trie(words)

        res = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, trie, i, j, '', res)
        return res

    @classmethod
    def dfs(cls, board: List[List[str]], trie: Dict, i: int, j: int, s: str, res: List[str]):
        char = board[i][j]
        m = len(board)
        n = len(board[0]) if m else 0
        if char not in trie:
            return

        trie = trie[char]
        s += char
        if cls.TRIE_END_CHAR in trie:
            res.append(s)
            return

        board[i][j] = cls.TRIE_END_CHAR

        for tmp_i, tmp_j in cls.DIRECTION_SET:
            new_i = tmp_i + i
            new_j = tmp_j + j

            if 0 <= new_i < m and 0 <= new_j < n and board[new_i][new_j] != cls.TRIE_END_CHAR:
                cls.dfs(board, trie, new_i, new_j, s, res)

        board[i][j] = char

    @classmethod
    def build_trie(cls, words: List[str]):
        root = {}
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, {})
            node[cls.TRIE_END_CHAR] = cls.TRIE_END_CHAR
        return root


if __name__ == '__main__':
    b = [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]]
    w = ["oath", "pea", "eat", "rain"]
    print(Solution().findWords(b, w))
