"""
    一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
    假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

    例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
    与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

    现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
    请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。
    如果无法实现目标变化，请返回 -1。

    注意:
        起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
        所有的目标基因序列必须是合法的。
        假定起始基因序列与目标基因序列是不一样的。

    示例 1:
        start: "AACCGGTT"
        end:   "AACCGGTA"
        bank: ["AACCGGTA"]
        返回值: 1

    示例 2:
        start: "AACCGGTT"
        end:   "AAACGGTA"
        bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
        返回值: 2

    示例 3:
        start: "AAAAACCC"
        end:   "AACCCCCC"
        bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
        返回值: 3

    https://leetcode-cn.com/problems/minimum-genetic-mutation
"""
from typing import List


class Solution:
    change_detail = {
        'A': 'GCT',
        'G': 'ACT',
        'C': 'AGT',
        'T': 'AGC'
    }

    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        counts = []
        if start and end and bank:
            self.recursive(start, end, bank, 0, counts)
        return min(counts) if counts else -1

    @classmethod
    def recursive(cls, start: str, end: str, bank: List[str], count: int, counts: List[int]) -> None:
        # terminator
        if start == end:
            counts.append(count)
        if not bank:
            return

        # code logic
        for index, s_row in enumerate(start):
            for change_info in cls.change_detail[s_row]:
                new_s_row = start[:index] + change_info + start[index + 1:]

                if new_s_row in bank:
                    bank.remove(new_s_row)

                    # drill down
                    cls.recursive(new_s_row, end, bank, count + 1, counts)

                    # reverse state
                    bank.append(new_s_row)
