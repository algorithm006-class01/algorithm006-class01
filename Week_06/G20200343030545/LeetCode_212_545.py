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
        # 1. 构建一棵trie树，并且初始化一个列表用来存储结果
        trie = self.build_trie(words)
        res = []

        # 2. 对board进行深度优先遍历
        row_len = len(board)
        col_len = len(board[0]) if board else 0  # 做一下容错
        for row_index in range(row_len):
            for col_index in range(col_len):
                self.dfs(board, trie, row_index, col_index, "", res)
        # 3. 输出结果
        return res

    @classmethod
    def dfs(cls, board: List[List[str]], trie: Dict[str, Dict], row_index: int, col_index: int, tmp_str: str,
            res: List[str]) -> None:
        """
            深度优先遍历
        """
        char = board[row_index][col_index]

        # terminator
        if char not in trie:
            return
        tmp_str += char
        trie = trie[char]
        if cls.TRIE_END_CHAR in trie:
            res.append(tmp_str)

        board[row_index][col_index] = cls.TRIE_END_CHAR  # 防止重复计算

        row_len = len(board)
        col_len = len(board[0])

        for tmp_row_index, tmp_col_index in cls.DIRECTION_SET:
            new_row_index = row_index + tmp_row_index
            new_col_index = col_index + tmp_col_index

            # drill down
            if 0 <= new_row_index < row_len and 0 <= new_col_index < col_len and board[new_row_index][
                new_col_index] != cls.TRIE_END_CHAR:
                cls.dfs(board, trie, new_row_index, new_col_index, tmp_str, res)
        # reverse state
        board[row_index][col_index] = char

    @classmethod
    def build_trie(cls, words: List[str]) -> Dict[str, Dict]:
        res = {}
        for word in words:
            trie = res

            for char in word:
                trie = trie.setdefault(char, {})
            trie[cls.TRIE_END_CHAR] = cls.TRIE_END_CHAR
        return res


if __name__ == '__main__':
    b = [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]]
    w = ["oath", "pea", "eat", "rain"]
    print(Solution().findWords(b, w))
