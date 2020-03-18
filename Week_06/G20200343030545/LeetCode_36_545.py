"""
    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    数独部分空格内已填入了数字，空白格用 '.' 表示。
"""
from typing import List, Tuple, Dict


class Solution:

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # 1、初始化数据
        rows, cols, box = self.init_data()

        # 2、循环遍历board 判断这对应上非.的数字是否合法
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != ".":
                    box_index = self.get_box_index(i, j)
                    rows[i][num] = rows[i].get(num, 0) + 1
                    cols[j][num] = cols[j].get(num, 0) + 1
                    box[box_index][num] = box[box_index].get(num, 0) + 1

                    if rows[i][num] > 1 or cols[j][num] > 1 or box[box_index][num] > 1:
                        return False
        return True

    @classmethod
    def init_data(cls) -> Tuple[List[Dict], List[Dict], List[Dict]]:
        rows = [{} for i in range(9)]
        cols = [{} for i in range(9)]
        box = [{} for i in range(9)]
        return rows, cols, box

    @classmethod
    def get_box_index(cls, row_index, col_index):
        return (row_index // 3) * 3 + col_index // 3
