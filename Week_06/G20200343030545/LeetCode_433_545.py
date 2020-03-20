"""
    一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
    假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
    例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
    与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

    现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
    请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

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
"""
from typing import List


class Solution:
    MAPPING = {
        "A": "GCT",
        "G": "ACT",
        "C": "AGT",
        "T": "AGC",
    }

    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        return self.two_end_bfs(start, end, bank)

    @classmethod
    def two_end_bfs(cls, start: str, end: str, bank: List[str]) -> int:
        if end not in bank:
            return -1

        start_queue = [start]
        end_queue = [end]
        start_len = len(start)

        visited = {}
        res = 0
        while start_queue:
            tmp_queue = []
            res += 1
            for tmp_start in start_queue:
                for i in range(start_len):
                    blur_start = cls.MAPPING.get(tmp_start[i])
                    for blur_char in blur_start:
                        cur_start = tmp_start[:i] + blur_char + tmp_start[i + 1:]
                        if cur_start not in bank:
                            continue

                        if cur_start in end_queue:
                            return res

                        if cur_start not in visited:
                            visited[cur_start] = 1
                            tmp_queue.append(cur_start)
            start_queue = tmp_queue
            if len(start_queue) > len(end_queue):
                start_queue, end_queue = end_queue, start_queue
        return -1

    @classmethod
    def bfs(cls, start: str, end: str, bank: List[str]) -> int:
        if end not in bank:
            return -1

        start_len = len(start)

        queue = [(start, 1)]
        visited = {}
        while queue:
            cur_start, cur_res = queue.pop(0)

            for index in range(start_len):
                blur_char = cur_start[index]
                for char in cls.MAPPING[blur_char]:
                    tmp_start = cur_start[:index] + char + cur_start[index + 1:]

                    if tmp_start not in bank:
                        continue

                    if tmp_start == end:
                        return cur_res

                    if tmp_start not in visited:
                        visited[tmp_start] = 1
                        queue.append((tmp_start, cur_res + 1))
        return -1
