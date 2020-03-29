"""
    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

    示例:
        board =
        [
          ['A','B','C','E'],
          ['S','F','C','S'],
          ['A','D','E','E']
        ]

        给定 word = "ABCCED", 返回 true
        给定 word = "SEE", 返回 true
        给定 word = "ABCB", 返回 false


    提示：
        board 和 word 中只包含大写和小写英文字母。
        1 <= board.length <= 200
        1 <= board[i].length <= 200
        1 <= word.length <= 10^3
"""

from typing import List


class Solution:

    def exist(self, board: List[List[str]], word: str) -> bool:

        word_len = len(word)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word, 0, word_len):
                    return True
        return False

    @classmethod
    def dfs(cls, board, i, j, word, index, word_len):
        char = board[i][j]

        if index == word_len - 1:
            return word[index] == char

        m = len(board)
        n = len(board[0]) if board else 0
        board[i][j] = "#"

        if char == word[index]:
            for tmp_i, tmp_j in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                new_i = tmp_i + i
                new_j = tmp_j + j
                if 0 <= new_i < m and 0 <= new_j < n and board[new_i][new_j] != "#" and cls.dfs(board, new_i, new_j,
                                                                                                word, index + 1,
                                                                                                word_len):
                    return True
        board[i][j] = char
        return False


if __name__ == '__main__':
    print(
        Solution().exist(
            [
                ["A", "B", "C", "E"],
                ["S", "F", "C", "S"],
                ["A", "D", "E", "E"]
            ],
            "ASAD"
        )
    )
